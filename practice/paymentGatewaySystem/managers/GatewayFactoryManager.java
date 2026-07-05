package practice.paymentGatewaySystem.managers;

import practice.paymentGatewaySystem.enums.GatewayType;
import practice.paymentGatewaySystem.factory.GatewayFactory;
import practice.paymentGatewaySystem.factory.GatewayFactoryImpl;
import practice.paymentGatewaySystem.paymentGateway.PaymentGateway;

public class GatewayFactoryManager {
    private static GatewayFactoryManager INSTANCE;

    private GatewayFactoryManager() {
        System.out.println("GatewayFactoryManager initialized...");
    }

    public static GatewayFactoryManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new GatewayFactoryManager();
        }
        return INSTANCE;
    }

    public PaymentGateway getGatewayType(GatewayType gatewayType) {
        GatewayFactory gatewayFactory = new GatewayFactoryImpl();
        return gatewayFactory.createGateway(gatewayType);
    }

}
