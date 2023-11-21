import * as readline from "readline";

class Person {
  name: string;

  constructor(name: string) {
    this.name = name;
  }

  greetPerson() {
    console.log(`Hallo ${this.name}`);
  }
}

// readline interface
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

// handle inputs
function askQuestion() {
  rl.question("War diese Aufgabe lehrreich für dich? [j / n] ", (answer: string) => {
    if (answer.toLowerCase() === "j") {
      console.log("Super!");
      rl.close();
    } else if (answer.toLowerCase() === "n") {
      console.log("Schade! :(");
      rl.close();
    } else {
      console.log("Ungültige Antwort!");
      askQuestion();
    }
  });
}

rl.question("Wie ist dein Name? ", (name: string) => {
  const person = new Person(name);
  person.greetPerson();
  askQuestion();
});