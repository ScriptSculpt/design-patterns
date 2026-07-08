package practice.couponDiscountEngine.couponStrategy;

public class PercentDiscount implements DiscountStrategy{
    double discountPercent;

    public PercentDiscount(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public double applyDiscount(double amount) {
        System.out.println("Percent Discount " + discountPercent + "% applied on " + amount);
        return amount - (amount * discountPercent / 100);
    }
}
