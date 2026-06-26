package practice.zomato;

import practice.zomato.entity.Address;
import practice.zomato.entity.Cart;
import practice.zomato.entity.CartItem;
import practice.zomato.entity.MenuItem;
import practice.zomato.entity.Order;
import practice.zomato.entity.Payment;
import practice.zomato.entity.Restaurant;
import practice.zomato.entity.User;
import practice.zomato.enums.PaymentStatus;
import practice.zomato.factory.PaymentFactory;
import practice.zomato.strategy.PaymentStrategy;

public class Main {
    public static void main(String[] args) {
        // Create a user and add an address
        User user = new User(0, "Marie");
        user.addAddress(new Address("123 Main St", "New York", "NY", "10001"));
        user.addAddress(new Address("456 Elm St", "Los Angeles", "CA", "90001"));

        // List all addresses for the user
        System.out.println("Addresses for user: " + user.getName());
        for (Address address : user.getAddresses()) {
            System.out.println(" - " + address.getStreet() + ", " + address.getCity() + ", " + address.getState() + " " + address.getZipCode());
        }

        // Create a restaurant
        Restaurant restaurant = new Restaurant(1, "Pasta Palace", "New York", 4.5);

        // Create menu items
        MenuItem menuItem1 = new MenuItem(1, "Spaghetti", 12.99);
        MenuItem menuItem2 = new MenuItem(2, "Lasagna", 14.99);

        // Add menu items to the restaurant
        restaurant.addMenuItem(menuItem1);
        restaurant.addMenuItem(menuItem2);

        // Create a cart for the user
        Cart cart = new Cart();
        user.setCart(cart);

        // Add menu items to the cart
        cart.addItem(new CartItem(menuItem1, 2));
        cart.addItem(new CartItem(menuItem2, 1));

        // Display cart items
        System.out.println(" --------------------------------------------------- ");
        System.out.println("Cart items for user: " + user.getName());
        for (CartItem cartItem : cart.getItems()) {
            System.out.println(" - " + cartItem.getName() + " x" + cartItem.getQuantity() + " = $" + (cartItem.getTotalPrice()));
        }

        // Display total amount
        double totalAmount = cart.getTotalAmount();
        System.out.println("Total amount for user: " + user.getName() + " is $" + totalAmount);


        // Use the PaymentFactory to get the appropriate payment strategy based on user preference
        PaymentStrategy paymentStrategy = PaymentFactory.getPaymentStrategy("CARD");
        paymentStrategy.pay(totalAmount);


        // Create a Payment object and process the payment
        System.out.println(" --------------------------------------------------- ");
        Payment payment = new Payment(totalAmount, PaymentStatus.PENDING);
        payment.processPayment();
        System.out.println("Payment status: " + payment.getStatus());

        
        System.out.println(" --------------------------------------------------- ");
        Order order = new Order(1, cart, user, restaurant, null, payment);
        System.out.println("Order created with ID: " + order.getId() + " for user: " + user.getName() + " at restaurant: " + restaurant.getName());

        
        System.out.println(restaurant.acceptOrder(order));

        System.out.println("Order status: " + order.getOrderStatus());
    }
}
