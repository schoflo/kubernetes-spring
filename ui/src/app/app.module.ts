import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {BoardgameEntryComponent} from './components/boardgame-entry/boardgame-entry.component';
import {MatInputModule} from "@angular/material/input";
import {MAT_FORM_FIELD_DEFAULT_OPTIONS} from "@angular/material/form-field";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatButtonModule} from "@angular/material/button";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {RouterOutlet} from "@angular/router";
import {AppRoutingModule} from './app-routing.module';
import {MatGridListModule} from "@angular/material/grid-list";
import {HomeComponent} from './components/home/home.component';
import {MatCardModule} from "@angular/material/card";
import {TileComponent} from './components/custom/tile/tile.component';
import {ReactiveFormsModule} from "@angular/forms";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MAT_DATE_LOCALE, MatNativeDateModule} from "@angular/material/core";

@NgModule({
  declarations: [
    AppComponent,
    BoardgameEntryComponent,
    HomeComponent,
    TileComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatSidenavModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    RouterOutlet,
    AppRoutingModule,
    MatGridListModule,
    MatCardModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  providers: [
    {provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: {appearance: 'outline'}},
    MatDatepickerModule,
    {provide: MAT_DATE_LOCALE, useValue: 'de-DE'}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
