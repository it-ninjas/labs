import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';
import { map, Observable } from 'rxjs';
import { BicycleService } from './services/bicycle.service';

@Injectable({
  providedIn: 'root',
})
export class SearchGuard implements CanActivate {
  constructor(private bicycleService: BicycleService) {}

  canActivate(): Observable<boolean> {
    console.log("test");
    
    return this.bicycleService.activedSubject.pipe(
      map((actived: boolean) => {
        console.log(actived);
        return actived;
      })
    );
  }

}
