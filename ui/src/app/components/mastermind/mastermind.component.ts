import {Component} from '@angular/core';
import {PinColor} from "../../util/constants/PinColor";
import {PinComponent} from "./pin/pin.component";
import {NgForOf, NgIf} from "@angular/common";
import {SolutionComponent} from "./solution/solution.component";
import {Point} from "chart.js";
import {PinState} from "./pin/PinState";
import {MatButtonModule} from "@angular/material/button";
import {SolutionColor} from "../../util/constants/SolutionColor";

@Component({
  selector: 'app-mastermind',
  standalone: true,
  imports: [
    PinComponent,
    NgForOf,
    SolutionComponent,
    MatButtonModule,
    NgIf
  ],
  templateUrl: './mastermind.component.html',
  styleUrl: './mastermind.component.scss'
})
export class MastermindComponent {
  protected readonly PinColor = PinColor;

  readonly ROWS = 10;
  readonly COLS = 4;
  gameField: PinState[][];
  solutions: SolutionColor[][];
  codeToSolve: PinColor[];
  currentlyFocussed: Point = null;
  gameWon = false;

  constructor() {
    this.initNewGame()
  }

  changeFocus(rowIndex: number, colIndex: number): void {
    if (this.currentlyFocussed) {
      this.gameField[this.currentlyFocussed.x][this.currentlyFocussed.y].inFocus = false;
    }
    this.currentlyFocussed = {x: rowIndex, y: colIndex};
  }

  applyPin(color: PinColor) {
    if (this.currentlyFocussed) {
      this.gameField[this.currentlyFocussed.x][this.currentlyFocussed.y].color = color;
      this.gameField[this.currentlyFocussed.x][this.currentlyFocussed.y].inFocus = false;

      if (this.currentlyFocussed.y !== this.COLS - 1) {
        this.currentlyFocussed.y++;
        this.gameField[this.currentlyFocussed.x][this.currentlyFocussed.y].inFocus = true;
      }
    }
  }


  checkRow(rowIndex: number): void {
    const solution: SolutionColor[] = [];
    this.gameField[rowIndex].forEach((pin, index) => {
      pin.checked = true;
      pin.inFocus = false;
      if (this.codeToSolve[index] === pin.color) {
        solution.push(SolutionColor.BLACK);
      } else if (this.codeToSolve.includes(pin.color)) {
        solution.push(SolutionColor.WHITE);
      } else {
        solution.push(SolutionColor.TRANSPARENT);
      }
    });
    this.solutions[rowIndex] = solution;
    if (solution.every(color => color === SolutionColor.BLACK)) {
      this.gameWon = true;
    }
    this.currentlyFocussed = null;
  }

  checkDisabled(rowIndex: number) {
    return this.gameWon ||
      !this.gameField[rowIndex].every(pin => pin.color !== PinColor.TRANSPARENT) ||
      this.gameField[rowIndex].some(pin => pin.checked);
  }

  initNewGame() {
    this.gameField = this.initGameField();
    this.solutions = this.initSolutions();
    this.codeToSolve = this.initRandomCode();
  }

  private initGameField(): PinState[][] {
    const gameField: PinState[][] = [];
    for (let i = 0; i < this.ROWS; i++) {
      gameField[i] = [];
      for (let j = 0; j < this.COLS; j++) {
        gameField[i][j] = this.defaultPinState();
      }
    }
    return gameField;
  }

  private initSolutions(): SolutionColor[][] {
    const solutions: SolutionColor[][] = [];
    for (let i = 0; i < this.ROWS; i++) {
      solutions[i] = [];
      for (let j = 0; j < this.COLS; j++) {
        solutions[i][j] = SolutionColor.TRANSPARENT;
      }
    }
    return solutions;
  }

  initRandomCode(): PinColor[] {
    const code: PinColor[] = [];
    const colors = Object.values(PinColor).filter(color => color !== PinColor.TRANSPARENT);
    for (let i = 0; i < this.COLS; i++) {
      const randomNumber = Math.floor(Math.random() * colors.length);
      code.push(colors[randomNumber]);
      colors.splice(randomNumber, 1);
    }
    return code;
  }

  defaultPinState(): PinState {
    return {
      color: PinColor.TRANSPARENT,
      inFocus: false,
      checked: false,
    };
  }

  coloredPinState(color: PinColor): PinState {
    return {
      color: color,
      inFocus: false,
      checked: false,
    };
  }
}
