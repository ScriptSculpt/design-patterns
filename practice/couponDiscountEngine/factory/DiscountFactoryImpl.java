package practice.couponDiscountEngine.factory;

import practice.couponDiscountEngine.couponStrategy.DiscountStrategy;
import practice.couponDiscountEngine.couponStrategy.FlatDiscount;
import practice.couponDiscountEngine.couponStrategy.PercentDiscount;
import practice.couponDiscountEngine.couponStrategy.PercentWithCapDiscount;
import practice.couponDiscountEngine.enums.StrategyType;

public class DiscountFactoryImpl implements DiscountFactory {

    @Override
    public DiscountStrategy getDiscountStrategy(StrategyType strategyType, double amount, double capAmount) {
        switch (strategyType) {
            case FLAT:
                return new FlatDiscount(amount);
            case PERCENT:
                return new PercentDiscount(amount);
            case PERCENT_WITH_CAP:
                return new PercentWithCapDiscount(amount, capAmount);
            default:
                return null;
        }
    }
    
}
