class User {
  name: string;
  age: number;
  email: string;

  constructor(name: string, age: number, email: string) {
    this.name = name;
    this.age = age;
    this.email = email;
  }

  validateEmail(): boolean {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(this.email);
  }

  getGreetingMessage(): string {
    return `Hello, ${this.name}!  Welcome!`;
  }
}

// Testing the User class
const user1 = new User("John Doe", 25, "johndoe@example.com");
console.log(user1.validateEmail()); // Output: true
console.log(user1.getGreetingMessage()); // Output: Hello, John Doe! Welcome!

const user2 = new User("Jane Smith", 16, "janesmith@example"); // Invalid email format
console.log(user2.validateEmail()); // Output: false
console.log(user2.getGreetingMessage()); // Output: Hello, Jane Smith! You must be accompanied by an adult.
