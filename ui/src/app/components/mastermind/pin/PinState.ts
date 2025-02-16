import {PinColor} from "../../../util/constants/PinColor";

export interface PinState {
  color: PinColor
  inFocus: boolean;
  checked: boolean;
}
