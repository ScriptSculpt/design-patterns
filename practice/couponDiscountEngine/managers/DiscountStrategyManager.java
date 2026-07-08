package practice.couponDiscountEngine.managers;

import practice.couponDiscountEngine.couponStrategy.DiscountStrategy;
import practice.couponDiscountEngine.enums.StrategyType;
import practice.couponDiscountEngine.factory.DiscountFactory;
import practice.couponDiscountEngine.factory.DiscountFactoryImpl;

public class DiscountStrategyManager {
    private static DiscountStrategyManager INSTANCE;
    private DiscountStrategyManager discountStrategy;

    private DiscountStrategyManager() {
        System.out.println("DiscountStrategyManager initialized...");
    }

    public static synchronized DiscountStrategyManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new DiscountStrategyManager();
        }
        return INSTANCE;
    }

    public DiscountStrategy getDiscountStrategy(StrategyType strategyType, double amount, double capAmount) {
        DiscountFactory discountFactory = new DiscountFactoryImpl();
        return discountFactory.getDiscountStrategy(strategyType, amount, capAmount);
    }
}
