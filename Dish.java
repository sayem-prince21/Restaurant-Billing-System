package model;

// Concrete class extending MenuItem for Dish items
public class Dish extends MenuItem {
    
    public Dish(int itemId, String itemName, double itemPrice) {
        super(itemId, itemName, itemPrice);
    }

    @Override
    public String getItemType() {
        return "Dish";
    }
}
