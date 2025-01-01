package application;

import model.MenuItem;
import model.Dish;
import model.Beverage;
import model.Order;
import service.MenuService;
import service.OrderService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        OrderService orderService = new OrderService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Restaurant Billing System ---");
            System.out.println("1. Add Menu Item");
            System.out.println("2. Remove Menu Item");
            System.out.println("3. View All Menu Items");
            System.out.println("4. Create New Order");
            System.out.println("5. Add Item to Order");
            System.out.println("6. Remove Item from Order");
            System.out.println("7. View Order Details");
            System.out.println("8. View All Orders");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addMenuItem(menuService, scanner);
                case 2 -> removeMenuItem(menuService, scanner);
                case 3 -> menuService.getAllMenuItems().forEach(System.out::println);
                case 4 -> System.out.println("New Order Created: " + orderService.createNewOrder().getOrderId());
                case 5 -> addItemToOrder(menuService, orderService, scanner);
                case 6 -> removeItemFromOrder(orderService, scanner);
                case 7 -> viewOrderDetails(orderService, scanner);
                case 8 -> orderService.listAllOrders();
                case 9 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addMenuItem(MenuService menuService, Scanner scanner) {
        System.out.print("Enter Item ID: ");
        int itemId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Item Name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter Item Price: ");
        double itemPrice = scanner.nextDouble();

        System.out.print("Enter Type (Dish/Beverage): ");
        String type = scanner.next();
        
        MenuItem menuItem;
        if (type.equalsIgnoreCase("Dish")) {
            menuItem = new Dish(itemId, itemName, itemPrice);
        } else {
            menuItem = new Beverage(itemId, itemName, itemPrice);
        }

        menuService.addMenuItem(menuItem);
        System.out.println("Menu item added successfully!");
    }

    private static void removeMenuItem(MenuService menuService, Scanner scanner) {
        System.out.print("Enter Item ID to Remove: ");
        int itemId = scanner.nextInt();
        menuService.deleteMenuItem(itemId);
        System.out.println("Menu item removed successfully!");
    }

    private static void addItemToOrder(MenuService menuService, OrderService orderService, Scanner scanner) {
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();
        System.out.print("Enter Menu Item ID: ");
        int itemId = scanner.nextInt();

        MenuItem menuItem = menuService.getMenuItemById(itemId);
        orderService.addItemToOrder(orderId, menuItem);
        System.out.println("Item added to order successfully!");
    }

    private static void removeItemFromOrder(OrderService orderService, Scanner scanner) {
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();
        System.out.print("Enter Item ID to Remove: ");
        int itemId = scanner.nextInt();

        orderService.removeItemFromOrder(orderId, itemId);
        System.out.println("Item removed from order successfully!");
    }

    private static void viewOrderDetails(OrderService orderService, Scanner scanner) {
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();
        System.out.println(orderService.getOrderById(orderId));
    }
}
