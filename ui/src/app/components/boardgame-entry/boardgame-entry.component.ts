import {Component} from '@angular/core';
import {BoardgameFacadeService, BoardgameModel} from "../../../../openapi";
import {FormBuilder, FormControl, Validators} from "@angular/forms";

@Component({
  selector: 'app-boardgame-entry',
  templateUrl: './boardgame-entry.component.html',
  styleUrls: ['./boardgame-entry.component.scss']
})
export class BoardgameEntryComponent {

  form = new FormBuilder().group({
    name: ['', {validators: [Validators.required]}],
    publisher: ['', {validators: [Validators.required]}],
    description: [''],
    price: new FormControl<number | null>(null),
    rating: new FormControl<number | null>(null),
    releasedate: new FormControl<Date | null>(null)
  })

  constructor(private boardgameFacadeService: BoardgameFacadeService) {
  }

  createBoardgame(): void {
    this.boardgameFacadeService.createBoardgame(this.createPayload()).subscribe((game: BoardgameModel) => {
      console.log(game);
    });
    console.log(this.form)
  }

  createPayload(): BoardgameModel {
    return {
      name: this.form.get('name')!.value,
      publisher: this.form.get('publisher').value,
      description: this.form.get('description').value,
      price: this.form.get('price').value,
      rating: this.form.get('rating').value,
      releasedate: this.form.get('releasedate').value.toISOString(),
    };
  }

}
