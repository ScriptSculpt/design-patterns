package practice.zepto.models;

import practice.zepto.segments.Cart;

public class User {
    private String name;
    private int coordX;
    private int coordY;
    private Cart cart;

    public User(String name, int coordX, int coordY, Cart cart) {
        this.name = name;
        this.coordX = coordX;
        this.coordY = coordY;
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

}
