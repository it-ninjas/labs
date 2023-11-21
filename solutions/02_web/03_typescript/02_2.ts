class Person {
    name: string;
  
    constructor(name: string) {
      this.name = name;
    }
  
    introduceSelf() {
      console.log(`Hallo, mein Name ist ${this.name}`);
    }
  }
  
  let personA = new Person("Hansli");
  
  personA.introduceSelf();