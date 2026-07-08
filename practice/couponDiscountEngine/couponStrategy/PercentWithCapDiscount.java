package practice.couponDiscountEngine.couponStrategy;

public class PercentWithCapDiscount implements DiscountStrategy {
    double discountPercent;
    double capAmount;

    public PercentWithCapDiscount(double discountPercent, double capAmount) {
        this.discountPercent = discountPercent;
        this.capAmount = capAmount;
    }

    @Override
    public double applyDiscount(double amount) {
        System.out.println("Percent Discount " + discountPercent + "% applied with cap " + capAmount + " on " + amount);

        double discount = amount * discountPercent / 100;
        discount = Math.min(discount, capAmount);

        return amount - discount;
    }
}
