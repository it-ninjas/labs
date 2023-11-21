import { Injectable } from '@angular/core';
import { Product } from '../models/product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private products: Product[] = [
    { name: 'Produkt 1', price: 9.99 },
    { name: 'Produkt 2', price: 19.99 },
    { name: 'Produkt 3', price: 14.99 },
  ];

  getProducts(): Product[] {
    return this.products;
  }
}
