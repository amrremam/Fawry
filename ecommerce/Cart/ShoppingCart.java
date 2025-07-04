package fawry.ecommerce.cart;

import fawry.ecommerce.model.Product;
import fawry.ecommerce.model.Shippable;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        if (!product.isAvailable(quantity)) {
            throw new IllegalArgumentException("Not enough stock or item expired: " + product.getName());
        }
        items.add(new CartItem(product, quantity));
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double calculateSubtotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public double calculateShippingFees() {
        return items.stream().filter(CartItem::isShippable).count() * 15;
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateShippingFees();
    }

    public List<Shippable> getItemsToShip() {
        List<Shippable> shippables = new ArrayList<>();
        for (CartItem item : items) {
            if (item.isShippable()) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippables.add((Shippable) item.getProduct());
                }
            }
        }
        return shippables;
    }
}
