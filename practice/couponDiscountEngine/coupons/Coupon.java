package practice.couponDiscountEngine.coupons;

import practice.couponDiscountEngine.models.Cart;

public abstract class Coupon {
    private Coupon nextHandler;

    public void setNextHandler(Coupon nextHandler) {
        this.nextHandler = nextHandler;
    }

    public Coupon getNextHandler() {
        return nextHandler;
    }

    public void applyDiscount(Cart cart) {
        if(isApplicable(cart)) {
            double discountedAmount = getDiscount(cart);
            cart.setUpdatedTotalPrice(discountedAmount);
        }
        if(nextHandler != null) {
            nextHandler.applyDiscount(cart);
        }
    };
    public abstract Boolean isApplicable(Cart cart);
    public abstract double getDiscount(Cart cart);
    public abstract String getCouponType();
}
