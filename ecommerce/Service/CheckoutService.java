package fawry.ecommerce.service;

import fawry.ecommerce.cart.*;
import fawry.ecommerce.model.Customer;
import fawry.ecommerce.model.Shippable;

import java.util.List;

public class CheckoutService {
    public static void checkout(Customer customer, ShoppingCart cart) {
        if (cart.isEmpty()) throw new RuntimeException("Cart is empty");

        for (CartItem item : cart.getItems()) {
            if (!item.getProduct().isAvailable(item.getQuantity())) {
                throw new RuntimeException("Product unavailable or expired: " + item.getProduct().getName());
            }
        }

        double total = cart.calculateTotal();

        if (!customer.hasSufficientBalance(total)) {
            throw new RuntimeException("Insufficient funds for checkout.");
        }

        // Deduct stock
        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceStock(item.getQuantity());
        }

        // Shipping
        List<Shippable> shippables = cart.getItemsToShip();
        if (!shippables.isEmpty()) {
            ShippingService.sendShipment(shippables);
        }

        // Payment
        customer.deduct(total);

        // Receipt
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s %.0f\n", item.getQuantity(), item.getProduct().getName(), item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f\n", cart.calculateSubtotal());
        System.out.printf("Shipping %.0f\n", cart.calculateShippingFees());
        System.out.printf("Amount %.0f\n", total);
        System.out.printf("Customer Balance %.0f\n", customer.getBalance());
    }
}
