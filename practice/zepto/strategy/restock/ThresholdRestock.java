package practice.zepto.strategy.restock;

public class ThresholdRestock implements RestockStrategy {
    @Override
    public void restock() {
        System.out.println("Threshold Restock");
    }
    
}
