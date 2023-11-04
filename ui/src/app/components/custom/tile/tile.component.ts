import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-tile',
  templateUrl: './tile.component.html',
  styleUrls: ['./tile.component.scss']
})
export class TileComponent {

  /** Name der in derm Tile stehen soll */
  @Input() name: string = '';
  /**Icon, welches oben rechts in dem Tile angezeigt wird */
  @Input() icon: string = '';
  /** Pfad auf den die Card ggf. weiterleite */
  @Input() routerLinkTile: string = "";
}
