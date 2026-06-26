package practice.zomato.factory;

import practice.zomato.entity.Payment;
import practice.zomato.strategy.CardPayment;
import practice.zomato.strategy.PaymentStrategy;
import practice.zomato.strategy.UpiPayment;

public class PaymentFactory {
    public static PaymentStrategy getPaymentStrategy(String paymentType) {
        switch (paymentType) {
            case "UPI":
                return new UpiPayment();
            case "CARD":
                return new CardPayment();
            default:
                throw new IllegalArgumentException("Invalid payment type");
        }
    }
}
