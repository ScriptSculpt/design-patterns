package practice.simpleFactoryDesignPrinciple.src;

public class BurgerFactory {
    public Burger createBurger(String type) {
        if(type.equals("simple")) {
            return new SimpleBurger();
        } else if(type.equals("premium")) {
            return new PremiumBurger();
        }
        return null;
    }
}
