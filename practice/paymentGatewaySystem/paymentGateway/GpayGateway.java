package practice.paymentGatewaySystem.paymentGateway;

import practice.paymentGatewaySystem.bankingSystem.Gpay;
import practice.paymentGatewaySystem.models.PaymentRequest;

public class GpayGateway extends PaymentGateway {

    public GpayGateway() {
        bankingSystem = new Gpay();
    }

    @Override
    public Boolean intializePayment(PaymentRequest paymentRequest) {
        if(paymentRequest.getAmount() <= 10) return false;
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
