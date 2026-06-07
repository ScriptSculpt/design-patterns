package practice.simpleFactoryDesignPrinciple.src;

public class PremiumBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing premium burger");
    } 
}
