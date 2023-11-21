import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'currencyFormat',
})
export class CurrencyFormatPipe implements PipeTransform {
  transform(value: number, currency: string = 'CHF'): string {
    let roundedValue = Math.round(value * 20) / 20;
    const remainder = roundedValue % 1;

    if (remainder <= 0.05) {
      roundedValue = Math.floor(roundedValue);
    } else if (remainder >= 0.95) {
      roundedValue = Math.ceil(roundedValue);
    } else {
      roundedValue = Math.floor(roundedValue * 20) / 20;
    }

    const formattedValue = roundedValue.toLocaleString('de-CH', {
      style: 'currency',
      currency: currency,
    });

    return formattedValue;
  }
}
