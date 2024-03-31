import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {RowingIntervalFacadeService, RowingIntervalModel, RowingSessionModel} from "../../../../openapi";
import {FormBuilder, FormControl, Validators} from "@angular/forms";
import {BehaviorSubject, filter, map, Observable} from "rxjs";
import {MatSelectChange} from "@angular/material/select";
import {MatSnackBar} from "@angular/material/snack-bar";
import {MatTableDataSource} from "@angular/material/table";
import {Chart} from "chart.js/auto";
import {RowingSessionService} from "../../services/rowing-session/rowing-session.service";
import {MatSort} from "@angular/material/sort";
import RowingModeEnum = RowingSessionModel.RowingModeEnum;


@Component({
  selector: 'app-rowing',
  templateUrl: './rowing.component.html',
  styleUrls: ['./rowing.component.scss']
})
export class RowingComponent implements OnInit, AfterViewInit {

  rowingIntervals$: Observable<RowingIntervalModel[]> = null;
  rowingSessionSubject$: BehaviorSubject<RowingSessionModel[]> = null;

  // *** Tabelle ***
  @ViewChild(MatSort) sort: MatSort;
  datasourceTable: MatTableDataSource<RowingSessionModel> = new MatTableDataSource<RowingSessionModel>();
  displayedColumns = ['workoutDate', 'rowingMode', 'rowingInterval', 'workoutTime', 'strokes', 'distance', 'calories'];


  rowingModes: string[] = Object.values(RowingModeEnum);
  timePattern = "^([0-9]{2}):([0-5][0-9]):([0-5][0-9])$";

  public chart: Chart = null;


  form = new FormBuilder().group({
    workoutDate: new FormControl<Date | null>(null, [Validators.required]),
    rowingMode: new FormControl<RowingModeEnum | null>(RowingModeEnum.Distance, [Validators.required]),
    rowingInterval: new FormControl<RowingIntervalModel | null>({value: null, disabled: true}),
    workoutTime: new FormControl<string | null>(null, [Validators.required]),
    strokes: new FormControl<number | null>(null, [Validators.required]),
    distance: new FormControl<number | null>(null, [Validators.required]),
    calories: new FormControl<number | null>(null)
  });


  constructor(private rowingSessionService: RowingSessionService,
              private rowingIntervalFacadeService: RowingIntervalFacadeService,
              private snackbar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.initObservables();
    this.createChart();
  }

  ngAfterViewInit(): void {
    this.initTableData();
  }

  createRowingSession() {
    this.rowingSessionService.createRowingSession(this.createPayload()).subscribe(() => {
      this.snackbar.open('Die Rudereinheit wurde erfolgreich angelegt!', null,
        {
          duration: 3000,
          horizontalPosition: "right",
          verticalPosition: "top",
          panelClass: 'custom-snackbar'
        });
    });
  }

  createPayload(): RowingSessionModel {
    return {
      id: null,
      workoutDate: this.form.get('workoutDate').value,
      rowingMode: this.form.get('rowingMode').value,
      rowingInterval: this.form.get('rowingInterval').value,
      workoutTime: this.timeStringToSeconds(this.form.get('workoutTime').value),
      strokes: this.form.get('strokes').value,
      distance: this.form.get('distance').value,
      calories: this.form.get('calories').value,
    };
  }

  reset() {
    throw new Error('Method not implemented.');
  }

  private timeStringToSeconds(str: string): number {
    if (!RegExp(this.timePattern).exec(str)) {
      console.error('Stringlänge beträgt nicht 10. Gebe 0 zurück');
      return 0;
    }
    return Number(str.substring(0, 2)) * 3600 + Number(str.substring(3, 5)) * 60 + Number(str.substring(6, 8));
  }

  protected readonly RowingModeEnum = RowingModeEnum;

  protected modeChanged(change: MatSelectChange) {
    const control = this.form.get('rowingInterval');
    if (change.value === RowingModeEnum.Interval) {
      control.enable();
    } else {
      control.disable();
      control.reset();
    }
  }

  private initObservables(): void {
    this.rowingIntervals$ = this.rowingIntervalFacadeService.getRowingIntervals();
    this.rowingSessionSubject$ = this.rowingSessionService.getRowingSessions$();
  }

  private initTableData(): void {
    this.datasourceTable.sort = this.sort;
    this.rowingSessionSubject$.subscribe(sessions => {
      this.datasourceTable.data = sessions;
    });
  }

  private createChart() {
    this.rowingSessionService.getRowingSessions$()
      .pipe(filter(rowingSessions => !!rowingSessions))
      .pipe(map(rowingSessions => {
        return {
          labels: rowingSessions.map(x => x.workoutDate),
          data: rowingSessions.map(y => (500 * y.workoutTime / 1000 / y.distance)),
        }
      }))
      .subscribe(rowingSessions => {
        if (this.chart) {
          this.chart.data.labels = rowingSessions.labels;
          this.chart.data.datasets[0].data = rowingSessions.data;
          this.chart.update();
        } else {
          this.chart = new Chart('chart-canvas', {
            type: 'line',
            data: {
              labels: rowingSessions.labels,
              datasets: [{
                label: 'Pace',
                data: rowingSessions.data,
                fill: false,
                borderColor: 'rgb(75, 192, 192)',
                tension: 0.1,
                cubicInterpolationMode: 'monotone'
              }]
            }
          });
        }
      });
  }
}
