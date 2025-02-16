import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {BoardgameEntryComponent} from "./components/boardgame-entry/boardgame-entry.component";
import {HomeComponent} from "./components/home/home.component";
import {RowingComponent} from "./components/rowing/rowing.component";
import {WebSocketTraingComponent} from "./components/websockets/web-socket-traing/web-socket-traing.component";
import {ROUTING_URL} from "./util/constants/RoutingUrl";
import {MastermindComponent} from "./components/mastermind/mastermind.component";

const routes: Routes = [
  {path: ROUTING_URL.BOARDGAMES, component: BoardgameEntryComponent},
  {path: ROUTING_URL.ROWING, component: RowingComponent},
  {path: ROUTING_URL.WEBSOCKET_TRAINING, component: WebSocketTraingComponent},
  {path: ROUTING_URL.MASTERMIND, component: MastermindComponent},
  {path: '', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
