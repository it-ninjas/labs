import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { FullBicycle } from '../models/bicycle.model';
import { BicycleService } from '../services/bicycle.service';

@Component({
  selector: 'app-bicycle-search',
  templateUrl: './bicycle-search.component.html',
  styleUrls: ['./bicycle-search.component.scss'],
})
export class BicycleSearchComponent implements OnInit {
  constructor(private bicycleService: BicycleService) {}

  public fullBicycle: FullBicycle = {
    name: '',
    value: 0,
    types: [''],
    brand: '',
  };
  public bicycleId: FormControl = new FormControl('');
  public error: string = '';

  ngOnInit(): void {
    this.bicycleService.errorSubject.subscribe((error: string) => {
      this.error = error;
    });
  }

  getBicycle(): void {
    this.fullBicycle = this.bicycleService.getFullBicycle(this.bicycleId.value);
  }
}
