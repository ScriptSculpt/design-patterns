package practice.couponDiscountEngine;

import java.util.List;

import practice.couponDiscountEngine.couponStrategy.DiscountStrategy;
import practice.couponDiscountEngine.coupons.BankOfferCoupon;
import practice.couponDiscountEngine.coupons.Coupon;
import practice.couponDiscountEngine.coupons.LoyaltyOfferCoupon;
import practice.couponDiscountEngine.coupons.SeasonalOfferCoupon;
import practice.couponDiscountEngine.enums.StrategyType;
import practice.couponDiscountEngine.managers.CouponManager;
import practice.couponDiscountEngine.managers.DiscountStrategyManager;
import practice.couponDiscountEngine.models.Cart;
import practice.couponDiscountEngine.models.Product;
import practice.couponDiscountEngine.models.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("John Doe", true, "SBI");

        Cart cart = new Cart();
        user.setCart(cart);

        Product product1 = new Product("Fridge", 20000.0, "Appliances");
        Product product2 = new Product("Watch", 2000.0, "Fashion");
        Product product3 = new Product("Laptop", 60000.0, "Electronics");

        cart.addItem(product1, 1);
        cart.addItem(product2, 2);
        cart.addItem(product3, 1);

        cart.setBank(user.getBank());
        cart.setLoyalty(user.getIsLoyaltyMember());

        
        double totalPrice = cart.getTotalPrice();
        System.out.println("Total price: " + totalPrice);

        System.out.println("==================== ");

        DiscountStrategyManager discountStrategyManager = DiscountStrategyManager.getInstance();

        DiscountStrategy flatDiscount = discountStrategyManager.getDiscountStrategy(StrategyType.FLAT, 600.0, 0);
        DiscountStrategy percentDiscount = discountStrategyManager.getDiscountStrategy(StrategyType.PERCENT, 20.0, 0);
        DiscountStrategy percentWithCapDiscount = discountStrategyManager.getDiscountStrategy(StrategyType.PERCENT_WITH_CAP, 20.0, 5000.0);

        Coupon seasonalOfferCoupon = new SeasonalOfferCoupon(percentDiscount, "Appliances");
        Coupon loyaltyOfferCoupon = new LoyaltyOfferCoupon(flatDiscount);
        Coupon bankOfferCoupon = new BankOfferCoupon(percentWithCapDiscount, "SBI");

        CouponManager couponManager = CouponManager.getInstance();
        couponManager.registerCoupon(seasonalOfferCoupon);
        couponManager.registerCoupon(loyaltyOfferCoupon);
        couponManager.registerCoupon(bankOfferCoupon);

        List<String> appliedCoupons = couponManager.getAppliedCoupons(cart);

        System.out.println("==================== ");
        System.out.println("Applied coupons:");
        for(String couponType : appliedCoupons) {
            System.out.println(couponType);
        }

        System.out.println("==================== ");
        double discountedTotalPrice = couponManager.applyCoupons(cart);

        System.out.println("==================== ");
        System.out.println("Discounted total price: " + discountedTotalPrice);

    }
}
