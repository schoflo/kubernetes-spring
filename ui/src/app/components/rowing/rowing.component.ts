import {Component, OnInit} from '@angular/core';
import {
  BoardgameModel,
  RowingFacadeService,
  RowingIntervalFacadeService,
  RowingIntervalModel,
  RowingSessionModel
} from "../../../../openapi";
import {FormBuilder, FormControl, Validators} from "@angular/forms";
import {Observable} from "rxjs";
import RowingModeEnum = RowingSessionModel.RowingModeEnum;


@Component({
  selector: 'app-rowing',
  templateUrl: './rowing.component.html',
  styleUrls: ['./rowing.component.scss']
})
export class RowingComponent implements OnInit {

  rowingIntervals$: Observable<RowingIntervalModel[]> = null;

  rowingModes: string[] = Object.values(RowingModeEnum);
  timePattern = "^([0-9]{2}):([0-5][0-9]):([0-5][0-9])$";

  form = new FormBuilder().group({
    workoutDate: new FormControl<Date | null>(null, [Validators.required]),
    rowingMode: new FormControl<RowingModeEnum | null>(RowingModeEnum.Distance, [Validators.required]),
    rowingInterval: new FormControl<RowingIntervalModel | null>(null),
    workoutTime: new FormControl<string | null>(null, [Validators.required]),
    strokes: new FormControl<number | null>(null, [Validators.required]),
    distance: new FormControl<number | null>(null, [Validators.required]),
    calories: new FormControl<number | null>(null)
  });


  constructor(private rowingFacadeService: RowingFacadeService,
              private rowingIntervalFacadeService: RowingIntervalFacadeService) {
  }

  ngOnInit(): void {
    this.initObservables();
  }

  createRowingSession() {
    this.rowingFacadeService.createRowingSession(this.createPayload()).subscribe((session: BoardgameModel) => {
      console.log(session);
    });
  }

  createPayload(): RowingSessionModel {
    return {
      id: null,
      workoutDate: this.form.get('workoutDate').value?.toISOString(),
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
    //TODO: Prüfen, ob man das nicht besser umwandeln kann vorher schon (Pipe?)
    if (!RegExp(this.timePattern).exec(str)) {
      console.error('Stringlänge beträgt nicht 10. Gebe 0 zurück');
      return 0;
    }
    return Number(str.substring(0, 2)) * 3600 + Number(str.substring(3, 5)) * 60 + Number(str.substring(6, 8));
  }

  private initObservables() {
    this.rowingIntervals$ = this.rowingIntervalFacadeService.getRowingIntervals();
  }

}
