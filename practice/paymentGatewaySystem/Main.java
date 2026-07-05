package practice.paymentGatewaySystem;

import practice.paymentGatewaySystem.controller.PaymentController;
import practice.paymentGatewaySystem.enums.GatewayType;
import practice.paymentGatewaySystem.models.PaymentRequest;

public class Main {
    public static void main(String[] args) {
        PaymentController paymentController = PaymentController.getInstance();


        PaymentRequest paymentRequest1 = new PaymentRequest("Alice", "Bob", 100);
        paymentController.handlePayment(GatewayType.GPAY, paymentRequest1);

        System.out.println(" ---------------------------------------------------- ");

        PaymentRequest paymentRequest2 = new PaymentRequest("Bob", "Alice", 20);
        paymentController.handlePayment(GatewayType.PAYTM, paymentRequest2);
    }
}
