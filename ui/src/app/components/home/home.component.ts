import {Component} from '@angular/core';
import {ROUTING_URL} from "../../util/constants/RoutingUrl";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  URL = ROUTING_URL;
}
