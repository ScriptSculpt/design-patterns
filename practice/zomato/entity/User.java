package practice.zomato.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private List<Address> addresses = new ArrayList<> ();
    private Cart cart;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }

    public String addAddress(Address address) {
        addresses.add(address);
        return "Address added successfully for user: " + name;
    }

    public String removeAddress(Address address) {
        addresses.remove(address);
        return "Address removed successfully for user: " + name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
    
}
