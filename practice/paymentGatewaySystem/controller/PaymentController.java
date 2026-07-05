package practice.paymentGatewaySystem.controller;

import practice.paymentGatewaySystem.enums.GatewayType;
import practice.paymentGatewaySystem.factory.GatewayFactory;
import practice.paymentGatewaySystem.factory.GatewayFactoryImpl;
import practice.paymentGatewaySystem.managers.GatewayFactoryManager;
import practice.paymentGatewaySystem.managers.PaymentService;
import practice.paymentGatewaySystem.models.PaymentRequest;
import practice.paymentGatewaySystem.paymentGateway.PaymentGateway;
import practice.zomato.entity.Payment;

public class PaymentController {
    private static PaymentController INSTANCE;
    private PaymentService paymentService;
    private GatewayFactoryManager gatewayFactoryManager;

    private PaymentController() {
        System.out.println("PaymentController initialized...");
        paymentService = PaymentService.getInstance();
        gatewayFactoryManager = GatewayFactoryManager.getInstance();
    }

    public static PaymentController getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new PaymentController();
        }
        return INSTANCE;
    }

    public void handlePayment(GatewayType gatewayType, PaymentRequest paymentRequest) {
        PaymentGateway paymentGateway = gatewayFactoryManager.getGatewayType(gatewayType);

        paymentService.setGateway(paymentGateway);
        paymentService.makePayment(paymentRequest);
    }
}
