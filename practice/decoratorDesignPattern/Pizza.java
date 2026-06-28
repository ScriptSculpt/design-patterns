package practice.decoratorDesignPattern;

import practice.decoratorDesignPattern.interfaces.PizzaBase;

public class Pizza implements PizzaBase {
    @Override
    public String prepare() {
        return "Preparing pizza";
    }
    
}
