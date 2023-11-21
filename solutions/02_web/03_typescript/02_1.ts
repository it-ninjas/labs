class Person {
    name: string;
  
    constructor(name: string) {
      this.name = name;
    }
  }
  
  class Friend extends Person {
    yearsKnown: number;
  
    constructor(name: string, yearsKnown: number) {
      super(name);
      this.yearsKnown = yearsKnown;
    }
  
    introduceSelf() {
      console.log(`Hallo, mein Name ist ${this.name}`);
    }
  
    timeKnown() {
      console.log(`Wir sind Freunde seit ${this.yearsKnown} Jahren`);
    }
  }
  
  const friend = new Friend("Peter", 5);
  friend.introduceSelf();
  friend.timeKnown();