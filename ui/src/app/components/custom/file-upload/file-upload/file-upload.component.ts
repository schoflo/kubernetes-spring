import {Component, ElementRef, HostListener} from '@angular/core';
import {ControlValueAccessor, NG_VALUE_ACCESSOR} from "@angular/forms";

@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.scss'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: FileUploadComponent,
      multi: true
    }
  ]
})
export class FileUploadComponent implements ControlValueAccessor {

  file: File | null = null;
  onChange: Function;

  @HostListener('change', ['$event.target.files']) emitFiles(event: FileList) {
    const file = event?.item(0);
    this.onChange(file);
    this.file = file;
  }

  constructor(private host: ElementRef<HTMLInputElement>) {
  }

  /**
   * Wird aufgerufen bei Initialisierung und bei patchValue/setValue
   * Da wir den Wert des Controls nicht darüber setzen wollen, wird hier nur null gesetzt.
   * @param value Ist hier immer null
   */
  writeValue(value: null) {
    // clear file input
    this.host.nativeElement.value = '';
    this.file = value;
  }

  /**
   * Wird aufgerufen, wenn wir über den HostListener ein ChangeEvent empfangen
   * @param fn
   */
  registerOnChange(fn: Function) {
    this.onChange = fn;
  }

  registerOnTouched(fn: any): void {
    throw new Error("not yet implemented");
  }
}
