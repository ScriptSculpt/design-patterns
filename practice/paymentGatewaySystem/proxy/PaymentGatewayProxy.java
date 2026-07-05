package practice.paymentGatewaySystem.proxy;

import practice.paymentGatewaySystem.models.PaymentRequest;
import practice.paymentGatewaySystem.paymentGateway.PaymentGateway;

public class PaymentGatewayProxy extends PaymentGateway {

    private PaymentGateway actualPaymentGateway;
    private int retries;

    public PaymentGatewayProxy(PaymentGateway actualPaymentGateway, int retries) {
        this.actualPaymentGateway = actualPaymentGateway;
        this.retries = retries;
    }

    @Override
    public Boolean intializePayment(PaymentRequest paymentRequest) {
        return actualPaymentGateway.intializePayment(paymentRequest);
    }

    @Override
    public Boolean processPayment(PaymentRequest paymentRequest) {
        int retriesLeft = retries;
        while(retriesLeft > 0) {
            if(actualPaymentGateway.processPayment(paymentRequest)) return true;
            retriesLeft--;
        }
        return false;
    }

    @Override
    public Boolean confirmPayment(PaymentRequest paymentRequest) {
        return actualPaymentGateway.confirmPayment(paymentRequest);
    }
    
}
