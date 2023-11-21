import { createFeatureSelector, createSelector } from '@ngrx/store';
import { ShoppingcartState } from './shoppingcart.reducer';

export const selectShoppingcartState = createFeatureSelector<ShoppingcartState>('shoppingCart');

export const selectShoppingcartItems = createSelector(
  selectShoppingcartState,
  (state: ShoppingcartState) => state.items
);