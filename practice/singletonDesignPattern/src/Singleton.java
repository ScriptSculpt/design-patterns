package practice.singletonDesignPattern.src;

public class Singleton {

    private static Singleton singleton = null;

    private Singleton() {
        System.out.println("Singleton class constructor called");
    }

    // Not thread safe
    public static Singleton getInstance() {
        if(singleton == null) {
            singleton = new Singleton();
        } 
        return singleton;
    }
}
