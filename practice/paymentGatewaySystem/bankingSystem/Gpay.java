package practice.paymentGatewaySystem.bankingSystem;

public class Gpay implements BankingSystem{
    @Override
    public Boolean processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " through Gpay.");

        double transactionRate = Math.random() % 100;
        return transactionRate < 80;
    }
    
}
