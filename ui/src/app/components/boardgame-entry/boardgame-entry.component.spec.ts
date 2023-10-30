import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoardgameEntryComponent } from './boardgame-entry.component';

describe('BoardgameEntryComponent', () => {
  let component: BoardgameEntryComponent;
  let fixture: ComponentFixture<BoardgameEntryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BoardgameEntryComponent]
    });
    fixture = TestBed.createComponent(BoardgameEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
