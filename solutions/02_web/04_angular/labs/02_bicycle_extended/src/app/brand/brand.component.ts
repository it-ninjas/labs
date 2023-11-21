import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FullBicycle } from '../models/bicycle.model';
import { BicycleService } from '../services/bicycle.service';
import { BrandService } from '../services/brand.service';

@Component({
  selector: 'app-brand',
  templateUrl: './brand.component.html',
  styleUrls: ['./brand.component.scss']
})
export class BrandComponent implements OnInit {
  constructor(private route: ActivatedRoute, private bicycleService: BicycleService, private brandService: BrandService){}

  brandId: number = 0;
  brandName: string = "";
  bicycals: FullBicycle[] = [];

  ngOnInit(): void {
    this.brandId = Number(this.route.snapshot.paramMap.get('id'));
    console.log(this.brandId);
    
    this.brandName = this.brandService.getBrandName(this.brandId)

    this.getAllBicyclesWithBrandId(this.brandId)
  }

  getAllBicyclesWithBrandId(brandId: number) {
    this.bicycals = this.bicycleService.getFullBicycleWithBrandId(brandId)  
  }
}
