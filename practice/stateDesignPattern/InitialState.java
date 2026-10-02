package practice.stateDesignPattern;

public class InitialState implements VendingMachineState {

    @Override
    public VendingMachineState insertCoin(VendingMachine vendingMachine, int amount) {
        vendingMachine.increaseCoinCount(amount);
        return vendingMachine.getHasCoinState();
    }

    @Override
    public VendingMachineState selectProduct(VendingMachine vendingMachine, int quantity) {
        System.out.println("Please insert coin first.");
        return vendingMachine.getInitialState();
    }

    @Override
    public VendingMachineState dispense(VendingMachine vendingMachine) {
        System.out.println("Please insert coin and select product first.");
        return vendingMachine.getInitialState();
    }

    @Override
    public VendingMachineState returnCoin(VendingMachine vendingMachine) {
        System.out.println("No coin to return.");
        return vendingMachine.getInitialState();
    }

    @Override
    public VendingMachineState refill(VendingMachine vendingMachine, int quantity) {
        vendingMachine.increaseProductCount(quantity);
        return vendingMachine.getInitialState();
    }
    
    @Override
    public String getStateName() {
        return "Initial State";
    }
    
}
