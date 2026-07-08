package practice.couponDiscountEngine.coupons;

import practice.couponDiscountEngine.couponStrategy.DiscountStrategy;
import practice.couponDiscountEngine.models.Cart;
import practice.couponDiscountEngine.models.CartItem;

public class SeasonalOfferCoupon extends Coupon {
    private DiscountStrategy strategy;
    private String category;


    public SeasonalOfferCoupon(DiscountStrategy strategy, String category) {
        this.strategy = strategy;
        this.category = category;
    }

    @Override
    public Boolean isApplicable(Cart cart) {
        for(CartItem item : cart.getItems()) {
            if(item.getProduct().getCategory().equals(category)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public double getDiscount(Cart cart) {
        return strategy.applyDiscount(cart.getUpdatedTotalPrice());
    }

    @Override
    public String getCouponType() {
        return "Seasonal Offer";
    }
    
}
