package practice.factoryMethodDesignPattern.src;

public interface MealFactory {
    Burger createBurger(String type);

    // NOTE: Having multiple items objects in this like createPizza(String type) makes it abstract factory design pattern, but here we are only creating burgers so it is factory method design pattern
}
