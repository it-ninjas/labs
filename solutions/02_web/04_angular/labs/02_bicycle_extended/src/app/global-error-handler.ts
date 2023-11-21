import { ErrorHandler, Injectable } from '@angular/core';
import { BicycleService } from './services/bicycle.service';

@Injectable()
export class GlobalErrorHandler extends ErrorHandler {

    constructor(private bicycleService: BicycleService) {
        super();
    }

  override handleError(error: any): void {
    this.bicycleService.errorSubject.next("Error!")
  }
}