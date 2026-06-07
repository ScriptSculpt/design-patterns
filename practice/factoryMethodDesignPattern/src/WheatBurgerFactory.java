package practice.factoryMethodDesignPattern.src;

public class WheatBurgerFactory implements MealFactory {
    @Override
    public Burger createBurger(String type) {
        if(type.equals("simple")) {
            return new SimpleWheatBurger();
        } else if(type.equals("premium")) {
            return new PremiumWheatBurger();
        }
        return null;
    }
}
