package practice.decoratorDesignPattern;

import practice.decoratorDesignPattern.interfaces.PizzaBase;

public class ExtraCheeseDecorator extends Decorator {
    public ExtraCheeseDecorator(PizzaBase pizzaBase) {
        super(pizzaBase);
    }

    @Override
    public String prepare() {
        return pizzaBase.prepare() + " and with extra cheese";
    }
    
}
