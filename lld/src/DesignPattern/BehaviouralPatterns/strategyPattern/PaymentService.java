package DesignPattern.BehaviouralPatterns.strategyPattern;

public class PaymentService {
    PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(){
        this.paymentStrategy.processPayment();
    }
}
