import { Observable } from "rxjs";

function getRandomInterval(min: number, max: number): number {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

const intervalObservable = new Observable<number>((subscriber) => {
  const emitInterval = () => {
    const interval = getRandomInterval(1000, 5000);
    subscriber.next(interval);
    setTimeout(emitInterval, interval);
  };
  emitInterval();
});

intervalObservable.subscribe((interval) => {
  console.log(`Interval: ${interval}ms`);
});
