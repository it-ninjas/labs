import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Store } from '@ngrx/store';
import { Todo } from '../models/todo.model';
import { add } from '../todo.actions';

@Component({
  selector: 'app-create-todo',
  templateUrl: './create-todo.component.html',
  styleUrls: ['./create-todo.component.scss']
})
export class CreateTodoComponent {
  constructor(private store: Store) {}

  public todoName: FormControl = new FormControl('');

  addTodo() {
    const todo: Todo = {
      id: new Date().getTime(),
      name: this.todoName.value,
      completed: false,
    };
    
    this.store.dispatch(add({ todo }));
    this.todoName.setValue('');
  }
}
