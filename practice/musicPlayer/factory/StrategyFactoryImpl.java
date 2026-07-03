package practice.musicPlayer.factory;

import practice.musicPlayer.enums.StrategyType;
import practice.musicPlayer.strategy.CustomPlayStrategy;
import practice.musicPlayer.strategy.PlayStrategy;
import practice.musicPlayer.strategy.SequentialPlayStrategy;
import practice.musicPlayer.strategy.ShufflePlayStrategy;

public class StrategyFactoryImpl implements StrategyFactory {

    @Override
    public PlayStrategy createStrategy(StrategyType strategyType) {
        switch (strategyType) {
            case SEQUENTIAL:
                return new SequentialPlayStrategy();
            case SHUFFLE:
                return new ShufflePlayStrategy();
            case CUSTOM:
                return new CustomPlayStrategy();
            default:
                throw new IllegalArgumentException("Invalid device type: " + strategyType);
        }
    }
    
}
