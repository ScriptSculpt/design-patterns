package practice.factoryMethodDesignPattern.src;

public class SimpleWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing simple wheat burger");
    }
    
}
