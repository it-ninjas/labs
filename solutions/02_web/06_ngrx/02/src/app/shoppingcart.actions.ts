import { createAction, props } from '@ngrx/store';
import { Product } from './models/product.model';


export enum ActionTypes {
    ADD = '[Shoppingcart Component] Add',
    REMOVE = '[Shoppingcart Component] Remove', 
}

export const add = createAction(ActionTypes.ADD, props<{ product: Product }>());
export const remove = createAction(ActionTypes.REMOVE, props<{ product: Product }>()
);
