package practice.decoratorDesignPattern;

import practice.decoratorDesignPattern.interfaces.PizzaBase;

public class Main {
    public static void main(String[] args) {
        PizzaBase pizza = new Pizza();
        pizza = new ToppingsDecorator(pizza);

        System.out.println(" =================== ");
        System.out.println(pizza.prepare());

        pizza = new ExtraCheeseDecorator(pizza);

        System.out.println(" =================== ");
        System.out.println(pizza.prepare());
    }
}
