import { createFeatureSelector, createSelector } from '@ngrx/store';
import { TodoState } from './todo.reducer';

export const selectTodoState = createFeatureSelector<TodoState>('todo');

export const selectTodos = createSelector(
  selectTodoState,
  (state: TodoState) => state.todos
);

export const selectOpenTodos = createSelector(selectTodos, (todos) =>
  todos.filter((todo) => {
    return !todo.completed;
  })
);
