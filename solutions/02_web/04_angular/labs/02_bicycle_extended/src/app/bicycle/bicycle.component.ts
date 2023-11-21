import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Bicycle, FullBicycle } from '../models/bicycle.model';
import { BicycleService } from '../services/bicycle.service';

@Component({
  selector: 'app-bicycle',
  templateUrl: './bicycle.component.html',
  styleUrls: ['./bicycle.component.scss'],
})
export class BicycleComponent implements OnInit {
  constructor(private bicycleService: BicycleService) {}

  public bicycles: Bicycle[] = [];
  public error: string = '';

  ngOnInit(): void {
    this.bicycles = this.getAllBicyle();
    this.bicycleService.errorSubject.subscribe((error: string) => {
      this.error = error;
    });
  }

  getAllBicyle() {
    return this.bicycleService.getAllBicycle();
  }

  actived(shouldBeActiv: boolean) {
    this.bicycleService.activedSubject.next(shouldBeActiv);
  }
}
