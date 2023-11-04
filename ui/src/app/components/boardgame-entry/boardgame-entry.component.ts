import {Component} from '@angular/core';
import {Boardgame, BoardgameFacadeService} from "../../../../openapi";
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
    this.boardgameFacadeService.createBoardgame("Northgard").subscribe((game: Boardgame) => {
      console.log(game);
    });
    console.log(this.form)
  }

}
