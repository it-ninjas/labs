import { createReducer, on } from '@ngrx/store';
import { Product } from './models/product.model';
import { add, remove } from './shoppingcart.actions';

export interface ShoppingcartState {
  items: Product[];
}

export const initialCartState: ShoppingcartState = {
  items: [],
};

export const shoppingCartReducer = createReducer(
  initialCartState,
  on(add, (state, { product }) => ({
    ...state,
    items: [...state.items, product],
  })),
  on(remove, (state, { product }) => ({
    ...state,
    items: state.items.filter((item) => item !== product),
  }))
);
