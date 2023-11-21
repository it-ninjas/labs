function calculateAverage(numbers: number[]): number {
  if (numbers.length === 0) {
    return NaN;
  }

  const sum = numbers.reduce((total, num) => total + num, 0);
  const average = sum / numbers.length;
  return average;
}

// Testing the function
const numbers1: number[] = [1, 2, 3, 4, 5];
const result1: number = calculateAverage(numbers1);
console.log(result1); // Output: 3

const numbers2: number[] = [];
const result2: number = calculateAverage(numbers2);
console.log(result2); // Output: NaN
