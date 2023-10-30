import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Boardgame} from "../../entity/Boardgame";

@Injectable({
  providedIn: 'root'
})
export class BoardgameService {

  constructor(private http: HttpClient) { }

  public findAll(): Observable<Boardgame[]> {
    return this.http.get<Boardgame[]>('http://localhost:8080/getBoardgames');
  }

}
