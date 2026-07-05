package practice.paymentGatewaySystem.paymentGateway;

import practice.paymentGatewaySystem.bankingSystem.BankingSystem;
import practice.paymentGatewaySystem.models.PaymentRequest;

public abstract class PaymentGateway {
    protected BankingSystem bankingSystem;
    
    public Boolean process(PaymentRequest paymentRequest) {
        System.out.println("Processing payment of " + paymentRequest.getAmount() + " from " + paymentRequest.getSender() + " to " + paymentRequest.getReceiver());
        
        if(!intializePayment(paymentRequest)) {
            System.out.println("Failed to initialize payment");
            return false;
        }

        if(!processPayment(paymentRequest)) {
            System.out.println("Failed to process payment");
            return false;
        }

        if(!confirmPayment(paymentRequest)) {
            System.out.println("Failed to confirm payment");
            return false;
        }

        return true;
    };

    public abstract Boolean intializePayment(PaymentRequest paymentRequest);
    public abstract Boolean processPayment(PaymentRequest paymentRequest);
    public abstract Boolean confirmPayment(PaymentRequest paymentRequest);

}
