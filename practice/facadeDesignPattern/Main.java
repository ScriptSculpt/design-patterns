package practice.facadeDesignPattern;

public class Main {
    public static void main(String[] args) {
       Facade facade = new Facade();

       Client client = new Client(facade);
       client.startSystem();
    }
}
