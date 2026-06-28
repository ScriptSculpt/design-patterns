package practice.decoratorDesignPattern;

import practice.decoratorDesignPattern.interfaces.PizzaBase;

public abstract class Decorator implements PizzaBase {
    protected PizzaBase pizzaBase;

    public Decorator(PizzaBase pizzaBase) {
        this.pizzaBase = pizzaBase;
    }
    
}
