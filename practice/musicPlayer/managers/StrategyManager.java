package practice.musicPlayer.managers;

import practice.musicPlayer.enums.StrategyType;
import practice.musicPlayer.factory.StrategyFactory;
import practice.musicPlayer.factory.StrategyFactoryImpl;
import practice.musicPlayer.strategy.PlayStrategy;

public class StrategyManager {
    private static StrategyManager instance;
    private PlayStrategy currentStrategy;

    private StrategyManager() {
        System.out.println("StrategyManager initialized...");
    }

    public static StrategyManager getInstance() {
        if (instance == null) {
            instance = new StrategyManager();
        }
        return instance;
    }

    public void setStrategy(StrategyType strategyType) {
        StrategyFactory strategyFactory = new StrategyFactoryImpl();
        this.currentStrategy = strategyFactory.createStrategy(strategyType);
    }

    public PlayStrategy getStrategy() {
            return this.currentStrategy;
        }
}
