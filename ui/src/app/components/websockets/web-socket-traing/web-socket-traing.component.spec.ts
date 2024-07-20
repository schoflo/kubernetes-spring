import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WebSocketTraingComponent } from './web-socket-traing.component';

describe('WebSocketTraingComponent', () => {
  let component: WebSocketTraingComponent;
  let fixture: ComponentFixture<WebSocketTraingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WebSocketTraingComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WebSocketTraingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
