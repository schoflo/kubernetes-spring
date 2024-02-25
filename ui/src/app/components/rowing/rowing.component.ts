import {Component} from '@angular/core';
import {RowingFacadeService} from "../../../../openapi";
import {FormBuilder, FormControl, Validators} from "@angular/forms";


@Component({
  selector: 'app-rowing',
  templateUrl: './rowing.component.html',
  styleUrls: ['./rowing.component.scss']
})
export class RowingComponent {

  imagePath: string = undefined;

  form = new FormBuilder().group({
    name: ['', {validators: [Validators.required]}],
    publisher: ['', {validators: [Validators.required]}],
    description: [''],
    price: new FormControl<number | null>(null),
    rating: new FormControl<number | null>(null),
    releasedate: new FormControl<Date | null>(null),
    image: new FormControl<Blob | null>(null)
  });


  constructor(private rowingFacadeService: RowingFacadeService) {
  }

  createRowingSession() {
    this.rowingFacadeService.getRowingSessions().subscribe(result => {
      console.log(result);
    })
  }

  reset() {
    console.error('Not yet implemented');
  }
}
