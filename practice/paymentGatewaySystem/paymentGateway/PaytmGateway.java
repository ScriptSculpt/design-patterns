package practice.paymentGatewaySystem.paymentGateway;

import practice.paymentGatewaySystem.bankingSystem.Paytm;
import practice.paymentGatewaySystem.models.PaymentRequest;

public class PaytmGateway extends PaymentGateway {

    public PaytmGateway() {
        bankingSystem = new Paytm();
    }

    @Override
    public Boolean intializePayment(PaymentRequest paymentRequest) {
        if(paymentRequest.getAmount() <= 0) return false;
        return true;
    }

    @Override
    public Boolean processPayment(PaymentRequest paymentRequest) {
        return bankingSystem.processPayment(paymentRequest.getAmount());
    }

    @Override
    public Boolean confirmPayment(PaymentRequest paymentRequest) {
        return true;
    }
    
}
