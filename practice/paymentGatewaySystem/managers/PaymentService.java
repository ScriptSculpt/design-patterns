package practice.paymentGatewaySystem.managers;

import practice.paymentGatewaySystem.models.PaymentRequest;
import practice.paymentGatewaySystem.paymentGateway.PaymentGateway;

public class PaymentService {
    private static PaymentService INSTANCE;
    private PaymentGateway paymentGateway;

    private PaymentService() {
        System.out.println("PaymentService initialized...");
    }

    public static PaymentService getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new PaymentService();
        }
        return INSTANCE;
    }

    public void setGateway(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public Boolean makePayment(PaymentRequest paymentRequest) {
        return paymentGateway.process(paymentRequest);
    }
}
