import {Component} from '@angular/core';
import {URL_BOARDGAMES, URL_HOME} from "../../util/constants/Url";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  protected readonly URL_BOARDGAMES = URL_BOARDGAMES;
  protected readonly URL_HOME = URL_HOME;
}
