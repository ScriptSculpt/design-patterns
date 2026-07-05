package practice.paymentGatewaySystem.factory;

import practice.paymentGatewaySystem.enums.GatewayType;
import practice.paymentGatewaySystem.paymentGateway.PaymentGateway;

public interface GatewayFactory {
    public PaymentGateway createGateway(GatewayType gatewayType);
}
