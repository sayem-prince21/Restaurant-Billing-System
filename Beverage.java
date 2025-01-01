package model;

// Concrete class extending MenuItem for Beverage items
public class Beverage extends MenuItem {
    
    public Beverage(int itemId, String itemName, double itemPrice) {
        super(itemId, itemName, itemPrice);
    }

    @Override
    public String getItemType() {
        return "Beverage";
    }
}
