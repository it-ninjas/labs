import { Injectable } from '@angular/core';
import { Brand } from '../models/brand.model';

@Injectable({
  providedIn: 'root',
})
export class BrandService {
  BrandMockData: Brand[] = [
    {
      brand_id: 1,
      name: 'Canyon',
      isCheapBrand: true,
    },
    {
      brand_id: 2,
      name: 'Trek',
      isCheapBrand: false,
    },
    {
      brand_id: 3,
      name: 'Propain',
      isCheapBrand: false,
    },
  ];

  constructor() {}

  getBrand(id: number): Brand {
    const brand = this.BrandMockData.find((brand) => brand.brand_id === id);
    if (!brand) {
      throw Error('No Brand with this ID found!');
    }
    return brand;
  }

  getBrandName(id: number): string {
    return this.getBrand(id).name;
  }
}
