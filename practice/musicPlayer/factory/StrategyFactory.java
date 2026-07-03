package practice.musicPlayer.factory;

import practice.musicPlayer.enums.StrategyType;
import practice.musicPlayer.strategy.PlayStrategy;

public interface StrategyFactory {
    PlayStrategy createStrategy(StrategyType strategyType);
}
