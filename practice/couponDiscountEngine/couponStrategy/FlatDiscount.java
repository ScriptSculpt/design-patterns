package practice.couponDiscountEngine.couponStrategy;

public class FlatDiscount implements DiscountStrategy {
    double discount;

    public FlatDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double applyDiscount(double amount) {
        System.out.println("Flat Discount " + discount + " applied on " + amount);
        return amount - discount;
    }
    
}
