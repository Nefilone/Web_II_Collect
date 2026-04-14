package collections_webinar_demo.examples;
import collections_webinar_demo.model.Order;

import java.util.*;

public class MapExample {

    public static void run() {

        System.out.println("\n=== MAP EXAMPLE ===");

        Map<Integer, Order> orders = new HashMap<>();

        orders.put(1, new Order(1, "Laptop"));
        orders.put(2, new Order(2, "Phone"));
        orders.put(3, new Order(3, "Keyboard"));

        System.out.println("Order with id 2:");

        System.out.println(orders.get(2));

    }

}