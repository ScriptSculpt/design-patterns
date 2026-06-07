package practice.singletonDesignPattern.src;

public class Main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstanceThreadSafeFast();
        Singleton s2 = Singleton.getInstanceThreadSafeFast();

        System.out.println("Are S1 and S2 same? : " + (s1 == s2));
    }
}
