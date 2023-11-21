import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { from, Observable, of } from 'rxjs';
import { Product } from '../models/product.model';
import { remove } from '../shoppingcart.actions';
import { selectShoppingcartItems } from '../shoppingcart.selector';

@Component({
  selector: 'app-shoppingcart',
  templateUrl: './shoppingcart.component.html',
  styleUrls: ['./shoppingcart.component.scss']
})
export class ShoppingcartComponent implements OnInit {
  cartItems$: Observable<Product[]> = new Observable;

  constructor(private store: Store) { }

  ngOnInit(): void {
    this.cartItems$ = this.store.select(selectShoppingcartItems);
  }


  removeFromCart(product: Product): void {
    this.store.dispatch(remove({ product }));
  }

  buy() {
    alert("Items buyed");
  }
}