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
import {FileUploadComponent} from './components/custom/file-upload/file-upload/file-upload.component';
import {RowingComponent} from './components/rowing/rowing.component';
import {MatSelectModule} from "@angular/material/select";
import {RowingIntervalPipe} from "./util/pipes/RowingIntervalPipe";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {MatTableModule} from "@angular/material/table";
import {WorkoutTimePipe} from "./util/pipes/WorkoutTimePipe";

@NgModule({
  declarations: [
    AppComponent,
    BoardgameEntryComponent,
    HomeComponent,
    TileComponent,
    FileUploadComponent,
    RowingComponent,
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
    MatNativeDateModule,
    MatSelectModule,
    MatSnackBarModule,
    RowingIntervalPipe,
    MatTableModule,
    WorkoutTimePipe
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
