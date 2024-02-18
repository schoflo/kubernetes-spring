import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RowingComponent } from './rowing.component';

describe('RowingComponent', () => {
  let component: RowingComponent;
  let fixture: ComponentFixture<RowingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RowingComponent]
    });
    fixture = TestBed.createComponent(RowingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
