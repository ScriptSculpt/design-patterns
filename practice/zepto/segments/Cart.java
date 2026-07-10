package practice.zepto.segments;

import java.util.ArrayList;
import java.util.List;


import practice.zepto.factory.ProductFactory;
import practice.zepto.models.CartItem;

public class Cart {
    List<CartItem> cartItems = new ArrayList<>();
    
    public void addItem(int sku, int quantity) {
        CartItem cartItem = new CartItem(ProductFactory.createProduct(sku), quantity);
        cartItems.add(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem cartItem : cartItems) {
            total += cartItem.getTotalPrice();
        }
        return total;
    }
}
