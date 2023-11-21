import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BicycleSearchComponent } from './bicycle-search/bicycle-search.component';
import { BicycleComponent } from './bicycle/bicycle.component';
import { BrandComponent } from './brand/brand.component';
import { SearchGuard } from './search.guard';

const routes: Routes = [
  { path: '', component: BicycleComponent },
  { path: 'search', canActivate: [SearchGuard], component: BicycleSearchComponent },
  { path: 'brand/:id', component:  BrandComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
