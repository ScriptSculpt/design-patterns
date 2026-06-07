package practice.singletonDesignPattern.src;

public class Singleton {

    private static Singleton INSTANCE = null;

    private Singleton() {
        System.out.println("Singleton class constructor called");
    }

    // Not thread safe
    public static Singleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Singleton();
        } 
        return INSTANCE;
    }

    // Thread safe but slow
    public static synchronized Singleton getInstanceThreadSafeSlow() {
        if(INSTANCE == null) {
            INSTANCE = new Singleton();
        } 
        return INSTANCE;
    }

    // Thread safe with double check locking, fast
    public static Singleton getInstanceThreadSafeFast() {
        if(INSTANCE == null) {
            synchronized(Singleton.class) {
                if(INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }


}
