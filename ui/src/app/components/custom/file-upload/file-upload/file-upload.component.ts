import {Component, ElementRef, HostListener} from '@angular/core';
import {ControlValueAccessor, NG_VALUE_ACCESSOR} from "@angular/forms";
import {FileUtils} from "../../../../util/file/FileUtils";

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
  protected readonly FileUtils = FileUtils;

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
   */
  writeValue() {
    this.file = null;
    this.host.nativeElement.value = '';
  }

  /**
   * Wird aufgerufen, wenn wir über den HostListener ein ChangeEvent empfangen
   * @param fn
   */
  registerOnChange(fn: Function) {
    this.onChange = fn;
  }

  /**
   * Benötigen wir nicht, muss aber implementiert werden für das Interface
   * @param fn
   */
  registerOnTouched(fn: any): void {
  }

  /**
   * Löscht den Datei und Dateiinhalt aus der HTML-Komponente
   */
  deleteFile(): void {
    this.onChange(null);
    this.file = null;
    this.host.nativeElement.value = '';
  }
}
