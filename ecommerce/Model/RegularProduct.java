package fawry.ecommerce.model;

public class RegularProduct extends Product {
    public RegularProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
