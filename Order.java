package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int orderId;
    private final List<MenuItem> orderedItems;
    private double orderTotal;

    public Order(int orderId) {
        this.orderId = orderId;
        this.orderedItems = new ArrayList<>();
        this.orderTotal = 0;
    }

    public int getOrderId() { return orderId; }
    public List<MenuItem> getOrderedItems() { return orderedItems; }
    public double getOrderTotal() { return orderTotal; }

    // Encapsulating add item operation
    public void addItemToOrder(MenuItem item) {
        orderedItems.add(item);
        orderTotal += item.getItemPrice();
    }

    // Encapsulating remove item operation
    public void removeItemFromOrder(int itemId) {
        orderedItems.removeIf(item -> {
            if (item.getItemId() == itemId) {
                orderTotal -= item.getItemPrice();
                return true;
            }
            return false;
        });
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order ID: " + orderId + "\nItems:\n");
        orderedItems.forEach(item -> sb.append(item).append("\n"));
        sb.append("Total: $").append(orderTotal);
        return sb.toString();
    }
}
