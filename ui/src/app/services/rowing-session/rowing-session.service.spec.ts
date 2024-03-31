import { TestBed } from '@angular/core/testing';

import { RowingSessionService } from './rowing-session.service';

describe('RowingSessionService', () => {
  let service: RowingSessionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RowingSessionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
