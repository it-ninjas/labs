let numbers = [];

function addNumbers() {
  const inputElement = document.getElementById("numberInput");
  const inputText = inputElement.value;
  const inputNumbers = inputText.split(",").map(Number);

  for (const num of inputNumbers) {
    if (!isNaN(num)) {
      numbers.push(num);
    }
  }

  inputElement.value = "";
  showInput();
}

function findLargest() {
  const largest = Math.max(...numbers);
  return largest;
}

function findSmallest() {
  const smallest = Math.min(...numbers);
  return smallest;
}

function sumEvenNumbers() {
  const evenSum = numbers
    .filter((num) => num % 2 === 0)
    .reduce((acc, curr) => acc + curr, 0);
  return evenSum;
}

function sumOddNumbers() {
  const oddSum = numbers
    .filter((num) => num % 2 !== 0)
    .reduce((acc, curr) => acc + curr, 0);
  return oddSum;
}

function sortNumbers() {
  const sorted = numbers.slice().sort((a, b) => a - b);
  return sorted;
}

function calculateTotal() {
  const total = numbers.reduce((acc, curr) => acc + curr, 0);
  return total;
}

function calculateAverage() {
  const average = numbers.reduce((acc, curr) => acc + curr, 0) / numbers.length;
  return average;
}

function showResults() {
  const resultElement = document.getElementById("result");
  resultElement.innerHTML = `
                <p>Größte Zahl: ${findLargest()}</p>
                <p>Kleinste Zahl: ${findSmallest()}</p>
                <p>Summe der geraden Zahlen: ${sumEvenNumbers()}</p>
                <p>Summe der ungeraden Zahlen: ${sumOddNumbers()}</p>
                <p>Sortierte Liste: ${sortNumbers()}</p>
                <p>Gesamtsumme: ${calculateTotal()}</p>
                <p>Durchschnitt: ${calculateAverage()}</p>
            `;
  resultElement.style.display = "unset";
}

function showInput() {
  const listElement = document.getElementById("inputList");
  listElement.innerHTML = `
        <p>Eingabe:</p>       
        <p>${numbers}</p>`;
}
