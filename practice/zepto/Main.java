package practice.zepto;

import practice.zepto.managers.OrderManager;
import practice.zepto.models.User;
import practice.zepto.segments.Cart;

public class Main {
    public static void main(String[] args) {
        ZeptoHelper.initialize();

        Cart cart = new Cart();
        System.out.println("Adding items to cart");
        cart.addItem(1, 7);
        cart.addItem(2, 10);
        cart.addItem(4, 1);

        User user = new User("John Doe", 1, 2, cart);
        ZeptoHelper.showItems(user);

        OrderManager orderManager = OrderManager.getInstance();
        orderManager.placeOrder(user, cart);
    }
}
