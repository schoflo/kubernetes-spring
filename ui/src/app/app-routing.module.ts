import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {BoardgameEntryComponent} from "./components/boardgame-entry/boardgame-entry.component";
import {HomeComponent} from "./components/home/home.component";
import {RowingComponent} from "./components/rowing/rowing.component";

const routes: Routes = [
  {path: 'boardgames', component: BoardgameEntryComponent},
  {path: 'rowing', component: RowingComponent},
  {path: '', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
