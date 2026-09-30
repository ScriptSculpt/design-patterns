package practice.flyweightDesignPattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Flyweight Design Pattern");

        FlyweightFactory flyweightFactory = new FlyweightFactory();
        Flyweight f1 = flyweightFactory.getFlyweight(2,4,1,"square");


        // Same flyweight object is used for different extrinsic contexts thus saving memory

        ExtrinsicContext context1 = new ExtrinsicContext(f1, 10, 20, "red");

        context1.draw();

        ExtrinsicContext context2 = new ExtrinsicContext(f1, 30, 40, "blue");

        context2.draw();
    }
}
