import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { Bicycle, FullBicycle } from '../models/bicycle.model';
import { BrandService } from './brand.service';
import { TypeService } from './type.service';

@Injectable({
  providedIn: 'root',
})
export class BicycleService {
  BicycleMockData: Bicycle[] = [
    {
      bicycle_id: 1,
      name: 'Spectra',
      value: 2500.98,
      type_ids: [1, 2],
      brand_id: 1,
    },
    {
      bicycle_id: 2,
      name: 'Domane',
      value: 3350.87,
      type_ids: [3],
      brand_id: 2,
    },
    {
      bicycle_id: 3,
      name: 'Ekano',
      value: 2004.23,
      type_ids: [1, 4],
      brand_id: 3,
    },
  ];

  public errorSubject: Subject<string> = new Subject<string>();
  public activedSubject: BehaviorSubject<boolean> =
    new BehaviorSubject<boolean>(false);

  constructor(
    private typeService: TypeService,
    private brandService: BrandService
  ) {}

  getBicycle(id: number): Bicycle {
    const bicycle = this.BicycleMockData.find(
      (bicycle) => bicycle.bicycle_id === id
    );
    if (!bicycle) {
      throw Error('No Bicycle with this ID found!');
    }
    return bicycle;
  }

  getAllBicycle(): Bicycle[] {
    if (this.BicycleMockData === null) {
      throw Error('No Bicycles are found!');
    }
    return this.BicycleMockData;
  }

  getFullBicycle(id: number): FullBicycle {
    const bicycle: Bicycle = this.getBicycle(id);

    const fullBicycle: FullBicycle = {
      name: bicycle.name,
      value: bicycle.value,
      types: this.typeService.getTypesName(bicycle.type_ids),
      brand: this.brandService.getBrandName(bicycle.brand_id),
    };

    return fullBicycle;
  }

  getFullBicycleWithBrandId(brandId: number): FullBicycle[] {
    let allBicycals: FullBicycle[] = [];

    const bicycles: Bicycle[] = this.BicycleMockData.filter((bicycle) => {
      return bicycle.brand_id === brandId;
    });

    if (!bicycles) {
      throw Error('No Bicycle with this Brand found!');
    }

    bicycles.forEach((bicycle) => {
      const fullBicycle: FullBicycle = {
        name: bicycle.name,
        value: bicycle.value,
        types: this.typeService.getTypesName(bicycle.type_ids),
        brand: this.brandService.getBrandName(bicycle.brand_id),
      };

      allBicycals.push(fullBicycle);
    });
    return allBicycals;
  }
}
