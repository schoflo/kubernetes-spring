export class FileUtils {

  /**
   * Berechnet die Dateigröße und gibt einen String zurück der als Suffix die größte Einheit mit der die Größe
   * ohne 0 vor dem Komma dargestellt werden kann. Berechnung dabei mit Faktor 1024 und nicht mit 1000. Berechnung
   * erfolgt auf zwei Nachkommastellen
   * Beispiel: Bei Übergabe von von 1069056 ist der Rückgabewert "2.01 mB"
   * @param size Dateigröße in Bytes
   */
  static calculateFileSize(size: number): string {
    let factor = 0;
    while (size > 1000) {
      size = size / 1024;
      factor++;
    }
    return size.toFixed(3) + this.calculateSizeName(factor);
  }

  private static calculateSizeName(factor: number): string {
    switch (factor) {
      case 0:
        return " B";
      case 1:
        return " kB";
      case 2:
        return " mB";
      case 3:
        return " gB";
      default:
        console.log('Datei zu groß');
        return "NaN"
    }
  }
}
