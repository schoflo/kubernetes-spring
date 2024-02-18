import {Component} from '@angular/core';
import {RowingFacadeService} from "../../../../openapi";

@Component({
  selector: 'app-rowing',
  templateUrl: './rowing.component.html',
  styleUrls: ['./rowing.component.scss']
})
export class RowingComponent {


  constructor(private rowingFacadeService: RowingFacadeService) {
  }

  createRowingSession() {
    this.rowingFacadeService.createRowingSession({
      rowingMode: "DISTANCE",
      rowingInterval: null,
      workoutTime: 30 * 60000,
      strokes: 1000,
      distance: 5000
    }).subscribe(result => {
      console.log(result)
    });
    this.rowingFacadeService.getRowingSessions().subscribe(result => {
      console.log(result);
    })
  }
}
