import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {
  Bicycle,
  BicycleImage,
  GoogleCustomSearchResponse,
} from '../interfaces';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-bicycle',
  templateUrl: './bicycle.component.html',
  styleUrls: ['./bicycle.component.scss'],
})
export class BicycleComponent implements OnInit {
  favoriteBicycle: BicycleImage[] = [];
  public bicycleName: FormControl = new FormControl('');

  constructor(private httpClient: HttpClient) {}

  ngOnInit(): void {
    this.bicycleName.setValue('Specialized Diverge Pro Carbon');
  }

  public displayBicycleName() {
    alert(this.bicycleName.value);
  }

  public getFavoriteBicycleImage(value: string) {
    this.favoriteBicycle = [];
    const url =
      'https://www.googleapis.com/customsearch/v1?key=AIzaSyDNGfS6NUdgwXOwKu9xlZPJFm84ylG6J4g&cx=005124428384360536924:rstfldysumw&q=' +
      value +
      '&searchType=image&safe=high';

    this.httpClient
      .get<GoogleCustomSearchResponse>(url)
      .subscribe((response: GoogleCustomSearchResponse) => {
        for (let i = 0; i < 4; i++) {
          let item: BicycleImage = response.items[i];
          item.image.height = (200 / item.image.width) * item.image.height;
          item.image.width = 200;
          this.favoriteBicycle.push(item);
        }
      });
  }
}
