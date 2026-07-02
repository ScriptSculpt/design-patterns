package practice.facadeDesignPattern;

public class Client {
    private Facade facade;
    public Client(Facade facade) {
        this.facade = facade;
    }

    public void startSystem() {
        facade.startSystem();
    }
}
