package practice.couponDiscountEngine.coupons;

import practice.couponDiscountEngine.couponStrategy.DiscountStrategy;
import practice.couponDiscountEngine.models.Cart;

public class BankOfferCoupon extends Coupon {
    private DiscountStrategy strategy;
    private String bank;

    public BankOfferCoupon(DiscountStrategy strategy, String bank) {
        this.strategy = strategy;
        this.bank = bank;
    }

    @Override
    public Boolean isApplicable(Cart cart) {
        return cart.getBank().equals(bank);
    }

    @Override
    public double getDiscount(Cart cart) {
        return strategy.applyDiscount(cart.getUpdatedTotalPrice());
    }

    @Override
    public String getCouponType() {
        return "Bank Offer";
    }
}
