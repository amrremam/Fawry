package fawry.ecommerce.service;

import fawry.ecommerce.model.Shippable;
import java.util.*;

public class ShippingService {
    public static void sendShipment(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        Map<String, Integer> countMap = new HashMap<>();
        double totalWeight = 0;

        for (Shippable item : items) {
            countMap.put(item.getName(), countMap.getOrDefault(item.getName(), 0) + 1);
            totalWeight += item.getWeight();
        }

        for (String name : countMap.keySet()) {
            System.out.printf("%dx %s\n", countMap.get(name), name);
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
