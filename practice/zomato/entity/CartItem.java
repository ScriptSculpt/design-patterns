package practice.zomato.entity;

import java.util.List;

public class CartItem {
    private MenuItem menuItems;
    private int quantity;

    public CartItem(MenuItem menuItems, int quantity) {
        this.menuItems = menuItems;
        this.quantity = quantity;
    }

    public String getName() {
        return menuItems.getName();
    }

    public double getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return menuItems.getPrice() * quantity;
    }
}
