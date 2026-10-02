package practice.stateDesignPattern;

public interface VendingMachineState {
    VendingMachineState insertCoin(VendingMachine vendingMachine, int amount);
    VendingMachineState selectProduct(VendingMachine vendingMachine, int quantity);
    VendingMachineState dispense(VendingMachine vendingMachine);
    VendingMachineState returnCoin(VendingMachine vendingMachine);
    VendingMachineState refill(VendingMachine vendingMachine, int quantity);
    String getStateName();
}
