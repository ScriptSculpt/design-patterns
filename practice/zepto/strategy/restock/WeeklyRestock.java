package practice.zepto.strategy.restock;

public class WeeklyRestock implements RestockStrategy {
    
    @Override
    public void restock() {
        System.out.println("Weekly Restock");
    }
    
}
