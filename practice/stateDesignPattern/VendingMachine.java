package practice.stateDesignPattern;

// Context Class
public class VendingMachine {
    private VendingMachineState currentState;
    private int productCount;
    private int selectedProductCount;
    private int coinCount;
 
    // State instances of the Vending Machine
    private VendingMachineState initialState;
    private VendingMachineState hasCoinState;
    private VendingMachineState productSelectedState;
    private VendingMachineState emptyState;

    public VendingMachine(int coinCount, int productCount) {
        this.coinCount = coinCount;
        this.productCount = productCount;

        // Initialize state instances
        initialState = new InitialState();
        hasCoinState = new HasCoinState();
        productSelectedState = new ProductSelectedState();
        emptyState = new EmptyState();

        // Set the initial state based on the product count
        if (productCount > 0) {
            currentState = initialState;
        } else {
            currentState = emptyState;
        }
    }

    public void insertCoin(int amount) {
        currentState = currentState.insertCoin(this, amount);
    }

    public void selectProduct(int quantity) {
        currentState = currentState.selectProduct(this, quantity);
    }

    public void dispense() {
        currentState = currentState.dispense(this);
    }

    public void returnCoin() {
        currentState = currentState.returnCoin(this);
    }

    public void refill(int quantity) {
        currentState = currentState.refill(this, quantity);
    }

    public void getCurrentStateName() {
        System.out.println("Current state:: " + currentState.getStateName());
    }

    public int getProductCount() {
        return productCount;
    }

    public int getCoinCount() {
        return coinCount;
    }

    public int getSelectedProductCount() {
        return selectedProductCount;
    }

    public void setSelectedProductCount(int selectedProductCount) {
        this.selectedProductCount = selectedProductCount;
    }

    public VendingMachineState getInitialState() {
        return initialState;
    }

    public VendingMachineState getHasCoinState() {
        return hasCoinState;
    }

    public VendingMachineState getProductSelectedState() {
        return productSelectedState;
    }

    public VendingMachineState getEmptyState() {
        return emptyState;
    }

    public void increaseCoinCount(int coinCount) {
        this.coinCount += coinCount;
        System.out.println("Coin count increased by " + coinCount + ". Total coins: " + this.coinCount);
    }

    public void decreaseCoinCount(int coinCount) {
        this.coinCount -= coinCount;
        System.out.println("Coin count decreased by " + coinCount + ". Total coins: " + this.coinCount);
    }

    public void increaseProductCount(int productCount) {
        this.productCount += productCount;
        System.out.println("Product count increased by " + productCount + ". Total products: " + this.productCount);
    }

    public void decreaseProductCount(int productCount) {
        this.productCount -= productCount;
        System.out.println("Product count decreased by " + productCount + ". Total products: " + this.productCount);
    }

    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }

}
