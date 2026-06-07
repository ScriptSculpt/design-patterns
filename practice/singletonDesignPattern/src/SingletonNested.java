package practice.singletonDesignPattern.src;

public class SingletonNested {
    private SingletonNested() {
        System.out.println("Singleton instance created");
    }

    private static class SingletonHelper {
        private static final SingletonNested INSTANCE = new SingletonNested();
    }

    public static SingletonNested getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
