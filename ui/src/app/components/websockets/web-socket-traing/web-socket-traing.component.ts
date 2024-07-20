import {Component, OnDestroy, OnInit} from '@angular/core';
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatInputModule} from "@angular/material/input";
import {FormBuilder, FormControl, ReactiveFormsModule, Validators} from "@angular/forms";

@Component({
  selector: 'app-web-socket-traing',
  standalone: true,
  imports: [
    MatDatepickerModule,
    MatInputModule,
    ReactiveFormsModule
  ],
  templateUrl: './web-socket-traing.component.html',
  styleUrl: './web-socket-traing.component.scss'
})
export class WebSocketTraingComponent implements OnInit, OnDestroy {
  private webSocket: WebSocket;
  private weatherNumber = -1;

  form = new FormBuilder().group({
    message: new FormControl<string | null>('', [Validators.required]),
  });

  constructor() {
    this.webSocket = new WebSocket('ws://localhost:8080/weather');
    this.webSocket.onmessage = (event) => {
      this.weatherNumber = JSON.parse(event.data);
      console.log(event);
    }
  }

  ngOnInit(): void {
    this.form.get('message').valueChanges.subscribe(value => {
      this.webSocket.send(value);
      console.log('changed!');
    });
  }

  ngOnDestroy(): void {
    this.webSocket.close();
  }
}
