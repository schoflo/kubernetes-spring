import {Pipe, PipeTransform} from '@angular/core';

/*
 * Stellt ein Dauer eines Workouts in einer schön lesbaren Form dar.
*/
@Pipe({
  standalone: true,
  name: 'workoutTimeStringRepresentation'
})
export class WorkoutTimePipe implements PipeTransform {

  HOUR = 3600000;

  transform(time: number): string {
    const timeString = new Date(time).toISOString().substring(11, 19);
    return time > this.HOUR ? timeString : timeString.substring(3);
  }

}
