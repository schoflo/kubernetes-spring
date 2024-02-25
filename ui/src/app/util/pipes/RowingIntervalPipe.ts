import {Pipe, PipeTransform} from '@angular/core';
import {RowingIntervalModel} from "../../../../openapi";

/*
 * Stellt ein Ruderintervall in einer schön lesbaren Form dar.
 * Form: "{Anzahl Wdh.}x{Einzelstrecke} | {Minuten}:{Sekunden} Pause"
*/
@Pipe({
  standalone: true,
  name: 'intervalStringRepresentation'
})
export class RowingIntervalPipe implements PipeTransform {

  STRING_SIZE = 9;

  transform(m: RowingIntervalModel): string {
    const repAndDist = m.repetitions + 'x' + m.singleDistance;
    const time = new Date(1000 * m.restTime).toISOString().substring(15, 19);
    //TODO: Padding funktioniert nicht bei der Anzeige
    return `${repAndDist.padEnd(this.STRING_SIZE)} | ${time} Pause`;
  }

}
