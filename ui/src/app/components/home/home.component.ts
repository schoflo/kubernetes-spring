import {Component, OnInit} from '@angular/core';
import {BoardgameService} from "../../service/boardgameService/boardgame.service";
import {Boardgame} from "../../entity/Boardgame";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  boardgames: Boardgame[] = [];

  constructor(private boardgameService: BoardgameService) {
  }

  ngOnInit(): void {
    this.boardgameService.findAll().subscribe(boardgames => {
      this.boardgames = boardgames;
      console.log(this.boardgames);
    });
  }


}
