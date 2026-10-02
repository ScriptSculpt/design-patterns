package practice.stateDesignPattern;

public class Main {

    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine(5,10);
        
        vendingMachine.getCurrentStateName();
        vendingMachine.insertCoin(2);
        vendingMachine.getCurrentStateName();
        vendingMachine.selectProduct(4);
        vendingMachine.getCurrentStateName();
        vendingMachine.returnCoin();
        vendingMachine.getCurrentStateName();
        vendingMachine.dispense();
        vendingMachine.getCurrentStateName();

    }
}
