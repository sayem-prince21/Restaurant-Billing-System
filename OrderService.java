package service;

import model.MenuItem;
import model.Order;
import java.util.ArrayList;

public class OrderService {
    private final ArrayList<Order> orders = new ArrayList<>();
    private int nextOrderId = 1;

    public Order createNewOrder() {
        Order order = new Order(nextOrderId++);
        orders.add(order);
        return order;
    }

    public void addItemToOrder(int orderId, MenuItem item) {
        getOrderById(orderId).addItemToOrder(item);
    }

    public void removeItemFromOrder(int orderId, int itemId) {
        getOrderById(orderId).removeItemFromOrder(itemId);
    }

    public Order getOrderById(int orderId) {
        return orders.stream()
                .filter(order -> order.getOrderId() == orderId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Order with ID " + orderId + " not found."));
    }

    public void listAllOrders() {
        orders.forEach(System.out::println);
    }
}
