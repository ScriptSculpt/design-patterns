package practice.couponDiscountEngine.models;

public class User {
    private String name;
    private Boolean isLoyaltyMember;
    private String bank;
    private Cart cart;


    public User(String name, Boolean isLoyaltyMember, String bank) {
        this.name = name;
        this.isLoyaltyMember = isLoyaltyMember;
        this.bank = bank;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getBank() {
        return bank;
    }

    public Boolean getIsLoyaltyMember() {
        return isLoyaltyMember;
    }


}
