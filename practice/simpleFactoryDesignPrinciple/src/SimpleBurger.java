package practice.simpleFactoryDesignPrinciple.src;

public class SimpleBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing simple burger");
    }
}
