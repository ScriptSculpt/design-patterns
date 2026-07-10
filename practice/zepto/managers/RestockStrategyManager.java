package practice.zepto.managers;

import practice.zepto.enums.RestockStrategyType;
import practice.zepto.strategy.restock.RestockStrategy;
import practice.zepto.strategy.restock.ThresholdRestock;
import practice.zepto.strategy.restock.WeeklyRestock;

public class RestockStrategyManager {
    private static RestockStrategyManager INSTANCE = null;

    private RestockStrategyManager() {
        System.out.println("RestockStrategyManager initialized...");
    }

    public static synchronized RestockStrategyManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RestockStrategyManager();
        }
        return INSTANCE;
    }

    // Simple Factory 
    public RestockStrategy createRestockType(RestockStrategyType restockStrategyType) {
        switch (restockStrategyType) {
            case THRESHOLD:
                return new ThresholdRestock();
            case WEEKLY:
                return new WeeklyRestock();
            default:
                return null;
        }
    }
}
