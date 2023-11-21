import { Observable } from "rxjs";
import { map } from "rxjs/operators";

function getRandomDegree(min: number, max: number): number {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

const temperatureInC = new Observable<number>((subscriber) => {
  setInterval(() => {
    subscriber.next(getRandomDegree(0, 45));
  }, 2000);
});

temperatureInC
  .pipe(
    map((temperatureInC) => {
      const temperatureInF = (temperatureInC * 9) / 5 + 32;
      return { celsius: temperatureInC, fahrenheit: temperatureInF };
    })
  )
  .subscribe(({ celsius, fahrenheit }) => {
    console.log(`Celsius: ${celsius} | Fahrenheit: ${fahrenheit}`);
  });
