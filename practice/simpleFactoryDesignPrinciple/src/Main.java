package practice.simpleFactoryDesignPrinciple.src;

public class Main {
    public static void main(String[] args) {
        String type = "premium";

        BurgerFactory factory = new BurgerFactory();
        Burger burger = factory.createBurger(type);
        burger.prepare();
    }
}
