package practice.couponDiscountEngine.factory;

import practice.couponDiscountEngine.couponStrategy.DiscountStrategy;
import practice.couponDiscountEngine.enums.StrategyType;

public interface DiscountFactory {
    DiscountStrategy getDiscountStrategy(StrategyType strategyType, double amount, double capAmount);
}
