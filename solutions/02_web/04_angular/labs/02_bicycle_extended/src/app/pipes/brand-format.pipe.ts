import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'brandFormat'
})
export class BrandFormatPipe implements PipeTransform {
  transform(value: string): string {
    const formattedBrand = value.toUpperCase() + ' ©';
    return formattedBrand;
  }
}