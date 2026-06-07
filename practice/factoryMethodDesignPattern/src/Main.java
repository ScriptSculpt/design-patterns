package practice.factoryMethodDesignPattern.src;

public class Main {
    public static void main(String[] args) {
        String type = "premium";
        MealFactory factory = new WheatBurgerFactory();

        Burger burger = factory.createBurger(type);
        burger.prepare();
    }
}
