package com.fawry.ecommerce;

import com.fawry.ecommerce.model.*;
import com.fawry.ecommerce.cart.*;
import com.fawry.ecommerce.service.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Amr", 500);

        Product cheese = new ShippableProduct("Cheese 200g", 100, 5, 0.2);         // shippable
        Product biscuits = new ShippableProduct("Biscuits 700g", 150, 3, 0.7);     // shippable
        Product scratchCard = new RegularProduct("Scratch Card", 50, 10);         // non-shippable

        ShoppingCart cart = new ShoppingCart();

        cart.addItem(cheese, 2);
        cart.addItem(biscuits, 1);
        cart.addItem(scratchCard, 1);

        try {
            CheckoutService.checkout(customer, cart);
        } catch (RuntimeException e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }
    }
}
