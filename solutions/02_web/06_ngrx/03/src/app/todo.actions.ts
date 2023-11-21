import { createAction, props } from '@ngrx/store';
import { Todo } from './models/todo.model';


export enum ActionTypes {
    ADD = '[Todo Component] Add',
    REMOVE = '[Todo Component] Remove', 
    COMPLETE = '[Todo Component] Complete'
}

export const add = createAction(ActionTypes.ADD, props<{ todo: Todo }>());
export const remove = createAction(ActionTypes.REMOVE, props<{ todoId: number }>());
export const complete = createAction(ActionTypes.COMPLETE, props<{ todoId: number }>());
