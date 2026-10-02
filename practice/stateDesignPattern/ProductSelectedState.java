package practice.stateDesignPattern;

/**
 * ProductSelectedState
 */
public class ProductSelectedState implements VendingMachineState {

    @Override
    public VendingMachineState insertCoin(VendingMachine vendingMachine, int amount) {
        System.out.println("Please wait, product already selected. Dispense the product first.");
        return vendingMachine.getProductSelectedState();
    }

    @Override
    public VendingMachineState selectProduct(VendingMachine vendingMachine, int quantity) {
        System.out.println("Product already selected. Please dispense the product first.");
        return vendingMachine.getProductSelectedState();
    }

    @Override
    public VendingMachineState dispense(VendingMachine vendingMachine) {
        int selectedQuantity = vendingMachine.getSelectedProductCount();
        vendingMachine.decreaseProductCount(selectedQuantity);
        vendingMachine.setSelectedProductCount(0);
        if (vendingMachine.getProductCount() == 0) {
            System.out.println("Products dispensed. The vending machine is now empty.");
            return vendingMachine.getEmptyState();
        }
        return vendingMachine.getInitialState();
    }

    @Override
    public VendingMachineState returnCoin(VendingMachine vendingMachine) {
        System.out.println("Cannot return coin, dispensing in progress. Please wait.");
        return vendingMachine.getProductSelectedState();
    }

    @Override
    public VendingMachineState refill(VendingMachine vendingMachine, int quantity) {
        System.out.println("Cannot refill while dispensing. Please wait.");
        return vendingMachine.getProductSelectedState();
    }

    @Override
    public String getStateName() {
        return "Product Selected State";
    }

}
