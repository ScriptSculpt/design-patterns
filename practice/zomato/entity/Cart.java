package practice.zomato.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();
    
    public Cart() {
        
    }

    public void addItem(CartItem item) {
        System.out.println("Adding item to cart " + item.getName() + " with quantity: " + item.getQuantity() + " and price: " + item.getQuantity());
        items.add(item);
    }

    public void removeItem(CartItem item) {
        System.out.println("Removing item from cart " + item.getName() + " with quantity: " + item.getQuantity() + " and price: " + item.getQuantity());
        items.remove(item);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void clearCart() {
        System.out.println("Clearing cart");
        items.clear();
    }

    public double getTotalAmount() {
        double total = 0;
        for(CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }
}
