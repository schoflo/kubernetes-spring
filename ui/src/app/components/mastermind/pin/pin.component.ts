import {Component, Input} from '@angular/core';
import {PinColor} from "../../../util/constants/PinColor";
import {NgClass, NgStyle} from "@angular/common";
import {PinState} from "./PinState";

@Component({
  selector: 'app-pin',
  standalone: true,
  imports: [
    NgStyle,
    NgClass
  ],
  templateUrl: './pin.component.html',
  styleUrl: './pin.component.scss'
})
export class PinComponent {

  @Input() pinState: PinState = {
    color: PinColor.TRANSPARENT,
    inFocus: false,
    checked: false,
  }

  clicked(): void {
    if (!this.pinState.checked) {
      this.pinState.inFocus = true;
    }
  }
}
