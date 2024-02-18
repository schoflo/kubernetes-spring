import {Component} from '@angular/core';
import {ROUTING_URL} from "./util/constants/RoutingUrl";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'schoflo';
  URL = ROUTING_URL;
}
