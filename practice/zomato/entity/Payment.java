package practice.zomato.entity;

import practice.zomato.enums.PaymentStatus;

public class Payment {
    private double amount;
    private PaymentStatus status;

    public Payment(double amount, PaymentStatus status) {
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public void processPayment() {
        // Simulate payment processing logic
        // For simplicity, we'll assume the payment is always successful
        System.out.println("Processing payment...");
        this.status = PaymentStatus.COMPLETED;
    }
}
