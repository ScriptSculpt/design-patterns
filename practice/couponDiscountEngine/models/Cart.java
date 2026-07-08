package practice.couponDiscountEngine.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();
    private Boolean isLoyalty;
    private String associatedBank;
    private double originalTotalPrice;
    private double updatedTotalPrice;
    

    public void addItem(Product product, int quantity) {
        CartItem cartItem = new CartItem(product, quantity);
        items.add(cartItem);
        originalTotalPrice += cartItem.getTotalPrice();
        updatedTotalPrice += cartItem.getTotalPrice();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return originalTotalPrice;
    }

    public double getUpdatedTotalPrice() {
        return updatedTotalPrice;
    }

    public void setUpdatedTotalPrice(double discountedTotalPrice) {
        this.updatedTotalPrice = discountedTotalPrice;
    }

    public void setLoyalty(Boolean isLoyalty) {
        this.isLoyalty = isLoyalty;
    }

    public Boolean getLoyalty() {
        return isLoyalty;
    }

    public void setBank(String bank) {
        this.associatedBank = bank;
    }

    public String getBank() {
        return associatedBank;
    }

}
