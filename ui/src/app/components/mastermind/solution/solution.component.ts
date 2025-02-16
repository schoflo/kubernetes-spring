import {Component, Input} from '@angular/core';
import {NgStyle} from "@angular/common";
import {SolutionColor} from "../../../util/constants/SolutionColor";

@Component({
  selector: 'app-solution',
  standalone: true,
  imports: [
    NgStyle
  ],
  templateUrl: './solution.component.html',
  styleUrl: './solution.component.scss'
})
export class SolutionComponent {

  @Input() solution: SolutionColor[];

}
