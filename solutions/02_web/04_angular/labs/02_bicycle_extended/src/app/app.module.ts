import { ErrorHandler, NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BicycleComponent } from './bicycle/bicycle.component';
import { GlobalErrorHandler } from './global-error-handler';
import { BrandFormatPipe } from './pipes/brand-format.pipe';
import { CurrencyFormatPipe } from './pipes/currency-format.pipe';
import { BicycleSearchComponent } from './bicycle-search/bicycle-search.component';
import { BrandComponent } from './brand/brand.component';

@NgModule({
  declarations: [
    AppComponent,
    BicycleComponent,
    BrandFormatPipe,
    CurrencyFormatPipe,
    BicycleSearchComponent,
    BrandComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [
    { provide: ErrorHandler, useClass: GlobalErrorHandler },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
