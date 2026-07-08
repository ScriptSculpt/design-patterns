package practice.couponDiscountEngine.managers;

import java.util.ArrayList;
import java.util.List;

import practice.couponDiscountEngine.coupons.Coupon;
import practice.couponDiscountEngine.models.Cart;

public class CouponManager {
    private static CouponManager INSTANCE = null;
    private Coupon currentCoupon = null;

    private CouponManager() {
        System.out.println("CouponManager initialized...");
    }

    public static synchronized CouponManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new CouponManager();
        }
        return INSTANCE;
    }

    public synchronized void registerCoupon(Coupon coupon) {
        if(currentCoupon == null) {
            currentCoupon = coupon;
            return;
        }

        Coupon temp = currentCoupon;
        
        while(temp.getNextHandler() != null) {
            temp = temp.getNextHandler();
        }
        temp.setNextHandler(coupon);
    }

    public synchronized List<String> getAppliedCoupons(Cart cart) {
        List<String> appliedCoupons = new ArrayList<>();
        Coupon temp = currentCoupon;

        while(temp != null) {
            if(temp.isApplicable(cart)) {
                appliedCoupons.add(temp.getCouponType());
            }
            temp = temp.getNextHandler();
        }
       
        return appliedCoupons;
    }

    public synchronized double applyCoupons(Cart cart) {
        if(currentCoupon != null) {
            currentCoupon.applyDiscount(cart);
        }
        return cart.getUpdatedTotalPrice();
    }

}
