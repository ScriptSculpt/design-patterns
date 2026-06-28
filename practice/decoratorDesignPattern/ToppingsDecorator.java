package practice.decoratorDesignPattern;

import practice.decoratorDesignPattern.interfaces.PizzaBase;

public class ToppingsDecorator extends Decorator {

    public ToppingsDecorator(PizzaBase pizzaBase) {
        super(pizzaBase);
    }

    @Override
    public String prepare() {
        // pizzaBase variable is coming from the protected instance variable of the Decorator class which is extended by this class. So we can use it here to call the prepare method of the Pizza class.
        return pizzaBase.prepare() + " with toppings";
    }
}
