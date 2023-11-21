import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TodoOverviewComponent } from './todo-overview/todo-overview.component';

const routes: Routes = [
  { path: '', redirectTo: '/todos', pathMatch: 'full' },
  { path: 'todos', component: TodoOverviewComponent }
]
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
