import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Product } from '../models/product.model';
import { ProductService } from '../services/product.service';
import { add, remove } from '../shoppingcart.actions';

@Component({
  selector: 'app-product-overview',
  templateUrl: './product-overview.component.html',
  styleUrls: ['./product-overview.component.scss'],
})
export class ProductOverviewComponent implements OnInit {
  products: Product[] = [];

  constructor(private productService: ProductService, private store: Store) { }

  ngOnInit(): void {
    this.products = this.productService.getProducts();
  }

  addToCart(product: Product): void {
    this.store.dispatch(add({ product }));
  }
}

