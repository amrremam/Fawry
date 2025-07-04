package fawry.ecommerce.cart;

import com.fawry.ecommerce.model.Product;

public class CartItem {
    private final Product product;
    private final int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isShippable() {
        return product instanceof com.fawry.ecommerce.model.Shippable;
    }
}
