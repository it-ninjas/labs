import { Injectable } from '@angular/core';
import { Type } from '../models/type.model';

@Injectable({
  providedIn: 'root',
})
export class TypeService {
  TypeMockData: Type[] = [
    {
      type_id: 1,
      type: 'Mountain Bike',
    },
    {
      type_id: 2,
      type: 'Downhill Bike',
    },
    {
      type_id: 3,
      type: 'Street Bike',
    },
    {
      type_id: 4,
      type: 'E-Bike',
    },
  ];

  constructor() {}

  getTypes(ids: number[]): Type[] {
    let types: Type[] = [];
    ids.forEach((id) => {
      const type = this.TypeMockData.find((type) => type.type_id === id);
      if (type) {
        types.push(type);
      } else {
        throw new Error(`No Type with ID ${id} found!`);
      }
    });
    return types;
  }

  getTypesName(ids: number[]): string[] {    
    return this.getTypes(ids).map((type) => type.type);
  }
}
