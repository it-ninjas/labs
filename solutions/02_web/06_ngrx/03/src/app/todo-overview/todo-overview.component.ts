import { Component, OnInit } from '@angular/core';
import { select, Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Todo } from '../models/todo.model';
import { add, complete, remove } from '../todo.actions';
import { selectOpenTodos, selectTodos } from '../todo.selector';

@Component({
  selector: 'app-todo-overview',
  templateUrl: './todo-overview.component.html',
  styleUrls: ['./todo-overview.component.scss']
})
export class TodoOverviewComponent  implements OnInit {

  constructor(private store: Store) { }

  todos$: Observable<Todo[]> = new Observable;

  ngOnInit() {
    this.todos$ = this.store.select(selectOpenTodos);  
  }


  removeTodo(todoId: number) {
    this.store.dispatch(remove({ todoId }));
  }

  completeTodo(todoId: number) {
    this.store.dispatch(complete({ todoId }));
  }
}
