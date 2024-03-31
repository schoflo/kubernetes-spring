import {Injectable} from '@angular/core';
import {RowingFacadeService, RowingSessionModel} from "../../../../openapi";
import {BehaviorSubject, Observable, tap} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RowingSessionService {

  private rowingSessions: RowingSessionModel[] = null;
  private rowingSessions$: BehaviorSubject<RowingSessionModel[]> = new BehaviorSubject<RowingSessionModel[]>(null);

  constructor(private rowingFacadeService: RowingFacadeService) {
    this.rowingFacadeService.getRowingSessions().subscribe(sessions => {
      this.rowingSessions = sessions;
      this.rowingSessions$.next(this.rowingSessions);
    });
  }

  getRowingSessions$(): BehaviorSubject<RowingSessionModel[]> {
    return this.rowingSessions$;
  }

  createRowingSession(rowingSessionModel: RowingSessionModel): Observable<RowingSessionModel> {
    return this.rowingFacadeService.createRowingSession(rowingSessionModel)
      .pipe(tap(session => {
        this.rowingSessions.push(session);
        this.rowingSessions$.next(this.rowingSessions);
        return rowingSessionModel;
      }))
  }
}
