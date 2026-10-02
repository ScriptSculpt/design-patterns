package practice.stateDesignPattern;

/**
 * HasCoinState
 */
public class HasCoinState implements VendingMachineState {
    
    @Override
    public VendingMachineState insertCoin(VendingMachine vendingMachine, int amount) {
        vendingMachine.increaseCoinCount(amount);
        return vendingMachine.getHasCoinState();
    }

    @Override
    public VendingMachineState selectProduct(VendingMachine vendingMachine, int quantity) {
        int availableProducts = vendingMachine.getProductCount();
        if (availableProducts < quantity) {
            System.out.println("Not enough products available. Please select a lower quantity.");
            return vendingMachine.getHasCoinState();
        }
        vendingMachine.setSelectedProductCount(quantity);
        return vendingMachine.getProductSelectedState();
    }

    @Override
    public VendingMachineState dispense(VendingMachine vendingMachine) {
        System.out.println("Please select a product first.");
        return vendingMachine.getHasCoinState();
    }

    @Override
    public VendingMachineState returnCoin(VendingMachine vendingMachine) {
        int coinCount = vendingMachine.getCoinCount();
        vendingMachine.setCoinCount(0);
        return vendingMachine.getInitialState();
    }

    @Override
    public VendingMachineState refill(VendingMachine vendingMachine, int quantity) {
        vendingMachine.increaseProductCount(quantity);
        return vendingMachine.getHasCoinState();
    }

    @Override
    public String getStateName() {
        return "Has Coin State";    
    }
}
