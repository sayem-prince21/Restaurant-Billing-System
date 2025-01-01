package service;

import model.MenuItem;
import java.util.ArrayList;

public class MenuService {
    private final ArrayList<MenuItem> menu = new ArrayList<>();

    public void addMenuItem(MenuItem menuItem) {
        menu.add(menuItem);
    }

    public void deleteMenuItem(int itemId) {
        menu.removeIf(item -> item.getItemId() == itemId);
    }

    public MenuItem getMenuItemById(int itemId) {
        return menu.stream()
                .filter(item -> item.getItemId() == itemId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Menu item with ID " + itemId + " not found."));
    }

    public ArrayList<MenuItem> getAllMenuItems() {
        return menu;
    }
}
