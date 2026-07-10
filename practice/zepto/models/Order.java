package practice.zepto.models;

import java.util.ArrayList;
import java.util.List;

import practice.zepto.segments.Cart;

public class Order {
    private int orderId = -1;
    private User user;
    private int coordX;
    private int coordY;
    private double totalAmount;
    private List<DeliveryPartner> deliveryPartner = new ArrayList<>();

    // just to reprent what Products are purchased and in how many quantity
    private List<CartItem> orderItems = new ArrayList<>();
    
    public Order(User user) {
        this.orderId++;
        this.user = user;
    }

    public void addDeliveryPartner(DeliveryPartner deliveryPartner) {
        this.deliveryPartner.add(deliveryPartner);
    }

    public void getDeliveryPartners() {
        for (DeliveryPartner deliveryPartner : deliveryPartner) {
            System.out.println(deliveryPartner.getName());
        }
    }

    public void addItemToOrder(CartItem cartItem) {
        orderItems.add(cartItem);
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<CartItem> getOrderItems() {
        return orderItems;
    }
}
