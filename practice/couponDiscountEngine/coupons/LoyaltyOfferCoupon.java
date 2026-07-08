package practice.couponDiscountEngine.coupons;

import practice.couponDiscountEngine.couponStrategy.DiscountStrategy;
import practice.couponDiscountEngine.models.Cart;

public class LoyaltyOfferCoupon extends Coupon {
    private DiscountStrategy strategy;

    public LoyaltyOfferCoupon(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Boolean isApplicable(Cart cart) {
        return cart.getLoyalty();
    }

    @Override
    public double getDiscount(Cart cart) {
        return strategy.applyDiscount(cart.getUpdatedTotalPrice());
    }
    
    @Override
    public String getCouponType() {
        return "LOYALTY";
    }
    
}
