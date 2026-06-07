package practice.singletonDesignPattern.src;

public class Main {
    public static void main(String[] args) {
        SingletonNested s1 = SingletonNested.getInstance();
        SingletonNested s2 = SingletonNested.getInstance();

        System.out.println("Are S1 and S2 same? : " + (s1 == s2));
    }
}
