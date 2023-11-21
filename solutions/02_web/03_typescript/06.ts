class Product {
  name: string;
  price: number;

  constructor(name: string, price: number) {
    this.name = name;
    this.price = price;
  }
}

class ShoppingCart {
  private items: Product[];

  constructor() {
    this.items = [];
  }

  addProduct(product: Product): void {
    this.items.push(product);
  }

  calculateTotalPrice(): number {
    let totalPrice = 0;
    for (const item of this.items) {
      totalPrice += item.price;
    }
    return totalPrice;
  }

  displayItems(): void {
    console.log("Items in the shopping cart:");
    for (const item of this.items) {
      console.log(`${item.name} - ${item.price} CHF`);
    }
  }
}

const cart = new ShoppingCart();

const product1 = new Product("Shirt", 25);
const product2 = new Product("Jeans", 50);
const product3 = new Product("Shoes", 80);

cart.addProduct(product1);
cart.addProduct(product2);
cart.addProduct(product3);

cart.displayItems();

console.log(`Total price: ${cart.calculateTotalPrice()} CHF`);
