import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { StoreModule } from '@ngrx/store';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductOverviewComponent } from './product-overview/product-overview.component';
import { shoppingCartReducer } from './shoppingcart.reducer';
import { ShoppingcartComponent } from './shoppingcart/shoppingcart.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductOverviewComponent,
    ShoppingcartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    StoreModule.forRoot({shoppingCart: shoppingCartReducer})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
