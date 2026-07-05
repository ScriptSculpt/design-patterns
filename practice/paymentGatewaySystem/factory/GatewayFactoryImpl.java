package practice.paymentGatewaySystem.factory;

import practice.paymentGatewaySystem.enums.GatewayType;
import practice.paymentGatewaySystem.paymentGateway.GpayGateway;
import practice.paymentGatewaySystem.paymentGateway.PaymentGateway;
import practice.paymentGatewaySystem.paymentGateway.PaytmGateway;
import practice.paymentGatewaySystem.proxy.PaymentGatewayProxy;

public class GatewayFactoryImpl implements GatewayFactory {
    @Override
    public PaymentGateway createGateway(GatewayType gatewayType) {
        switch(gatewayType){
            case PAYTM:
                return new PaymentGatewayProxy(new PaytmGateway(), 3);
            case GPAY:
                return new PaymentGatewayProxy(new GpayGateway(), 2);
            default:
                return null;
        }
    }
}
