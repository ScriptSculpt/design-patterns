package practice.paymentGatewaySystem.models;

public class PaymentRequest {
    private String sender;
    private String receiver;
    private double amount;

    public PaymentRequest(String sender, String receiver, double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public double getAmount() {
        return amount;
    }
}
