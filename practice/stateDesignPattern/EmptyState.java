package practice.stateDesignPattern;

/**
 * EmptyState
 */
public class EmptyState implements VendingMachineState {

    @Override
    public VendingMachineState insertCoin(VendingMachine vendingMachine, int amount) {
        System.out.println("Cannot insert coin. The vending machine is empty.");
        return vendingMachine.getEmptyState();
    }

    @Override
    public VendingMachineState selectProduct(VendingMachine vendingMachine, int quantity) {
        System.out.println("Cannot select product. The vending machine is empty.");
        return vendingMachine.getEmptyState();
    }

    @Override
    public VendingMachineState dispense(VendingMachine vendingMachine) {
        System.out.println("Cannot dispense product. The vending machine is empty.");
        return vendingMachine.getEmptyState();
    }

    @Override
    public VendingMachineState returnCoin(VendingMachine vendingMachine) {
        System.out.println("No coin to return. The vending machine is empty.");
        return vendingMachine.getEmptyState();
    }

    @Override
    public VendingMachineState refill(VendingMachine vendingMachine, int quantity) {
        System.out.println("Refilling vending machine.");
        vendingMachine.increaseProductCount(quantity);
        return vendingMachine.getInitialState();
    }

    @Override
    public String getStateName() {
        return "Empty State";
    }

}
