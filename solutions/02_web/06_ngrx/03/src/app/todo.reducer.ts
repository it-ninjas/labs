import { createReducer, on } from '@ngrx/store';
import { Todo } from './models/todo.model';
import { add, remove, complete } from './todo.actions';

export interface TodoState {
  todos: Todo[];
}

export const initialTodoState: TodoState = {
  todos: [],
};

export const todoReducer = createReducer(
    initialTodoState,
    on(add, (state, { todo }) => ({
      ...state,
      todos: [...state.todos, todo],
    })),
    on(remove, (state, { todoId }) => ({
      ...state,
      todos: state.todos.filter((todo) => todo.id !== todoId),
    })),
    on(complete, (state, { todoId }) => ({
      ...state,
      todos: state.todos.map((todo) =>
      todo.id === todoId ? { ...todo, completed: true } : todo
      ),
    }))
);
