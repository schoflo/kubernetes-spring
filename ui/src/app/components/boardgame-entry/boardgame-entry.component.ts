import {Component} from '@angular/core';
import {Boardgame, BoardgameFacadeService} from "../../../../openapi";

@Component({
  selector: 'app-boardgame-entry',
  templateUrl: './boardgame-entry.component.html',
  styleUrls: ['./boardgame-entry.component.scss']
})
export class BoardgameEntryComponent {

  constructor(private boardgameFacadeService: BoardgameFacadeService) {
  }

  createBoardgame(): void {
    this.boardgameFacadeService.createBoardgame("Northgard").subscribe((game: Boardgame) => {
      console.log(game);
    });
  }

}
