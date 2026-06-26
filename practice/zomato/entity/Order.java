package practice.zomato.entity;

import java.util.List;

import practice.zomato.enums.OrderStatus;

public class Order {
    private int id;
    private Cart cart;
    private User user;
    private Restaurant restaurant;
    private OrderStatus orderStatus;
    private Payment payment;
    

    public Order(int id, Cart cart, User user, Restaurant restaurant, OrderStatus orderStatus, Payment payment) {
        this.id = id;
        this.cart = cart;
        this.user = user;
        this.restaurant = restaurant;
        this.orderStatus = orderStatus.PLACED;
        this.payment = payment;
    }

    public int getId() {
        return id;
    }

    public double getTotalAmount() {
        return cart.getTotalAmount();
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }



}
