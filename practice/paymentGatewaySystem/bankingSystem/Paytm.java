package practice.paymentGatewaySystem.bankingSystem;

public class Paytm implements BankingSystem {
    @Override
    public Boolean processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " through Paytm.");

        double transactionRate = Math.random() % 100;
        return transactionRate < 20;
    }
    
}
