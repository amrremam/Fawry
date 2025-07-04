package fawry.ecommerce.model;

public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract boolean isExpired();

    public boolean isAvailable(int requestedQty) {
        return quantity >= requestedQty && !isExpired();
    }

    public void reduceStock(int qty) {
        this.quantity -= qty;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}