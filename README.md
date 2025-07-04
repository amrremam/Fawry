# 🛒 Fawry E-Commerce System (Java)

This is a basic object-oriented Java application that simulates a mini e-commerce system with features such as:

- Product definition (expirable, shippable, etc.)
- Customer cart handling
- Checkout and payment processing
- Shipment generation for shippable items

> ✅ Built as part of the **Fawry Quantum Internship Challenge**

---

## 📦 Features

### ✅ Product Types
- **Expirable products** (e.g. Cheese, Biscuits)
- **Shippable products** with weight (e.g. Cheese, TV)
- **Non-expirable, non-shippable** products (e.g. Scratch Card)

### ✅ Cart & Checkout
- Add products to cart with specific quantity
- Validations:
  - Cannot add more than available stock
  - Cannot buy expired products
  - Cannot checkout with insufficient balance
  - Cannot checkout an empty cart
- Generates:
  - Order subtotal
  - Shipping fee
  - Final amount
  - Updated customer balance
  - Shipment summary (if applicable)

---

## 🧪 Sample Scenario

```java
cart.addItem(cheese, 2);
cart.addItem(biscuits, 1);
cart.addItem(scratchCard, 1);
CheckoutService.checkout(customer, cart);

** Shipment notice **
2x Cheese 200g
1x Biscuits 700g
Total package weight 1.1kg
** Checkout receipt **
2x Cheese 200
1x Biscuits 150
1x Scratch Card 50
----------------------
Subtotal 400
Shipping 45
Amount 445
Customer Balance 55


fawry/ecommerce/
├── fawry/ecommerce/
│       ├── Main.java
│       ├── model/         # Product, Customer, etc.
│       ├── cart/          # ShoppingCart & CartItem
│       └── service/       # Checkout and Shipping Services



javac -d out fawry/ecommerce/**/*.java


java -cp out fawry.ecommerce.Main
