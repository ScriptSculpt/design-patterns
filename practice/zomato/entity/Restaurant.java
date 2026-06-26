package practice.zomato.entity;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private String location;
    private double rating;
    private List<MenuItem> menuItems = new ArrayList<>();

    public Restaurant(int id, String name, String location, double rating) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getRating() {
        return rating;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void removeMenuItem(MenuItem menuItem) {
        menuItems.remove(menuItem);
    }

    public String acceptOrder(Order order) {
        return "Order accepted by restaurant: " + name + " for order id: " + order.getId();
    }

    public String rejectOrder(Order order) {
        return "Order rejected by restaurant: " + name + " for order id: " + order.getId();
    }

}
