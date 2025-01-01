package model;

// Abstract class for MenuItem to allow different types of items in the menu
public abstract class MenuItem {
    private final int itemId;
    private final String itemName;
    private final double itemPrice;

    public MenuItem(int itemId, String itemName, double itemPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public int getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public double getItemPrice() { return itemPrice; }

    // Abstract method to get the type of the item
    public abstract String getItemType();
    
    @Override
    public String toString() {
        return "ID: " + itemId + ", Name: " + itemName + ", Price: $" + itemPrice + ", Type: " + getItemType();
    }
}
