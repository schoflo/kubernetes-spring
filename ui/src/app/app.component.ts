import {Component} from '@angular/core';
import {URL_BOARDGAMES, URL_HOME} from "./util/constants/UrlConstants";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'schoflo';
  protected readonly URL_HOME = URL_HOME;
  protected readonly URL_BOARDGAMES = URL_BOARDGAMES;
}
