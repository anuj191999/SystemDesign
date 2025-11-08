package DesignPattern.BehaviouralPatterns.strategyPattern;

public class DebitCardPayment implements PaymentStrategy {

    @Override
    public void processPayment() {
        System.out.println("Making Payment via Debit card");
    }
}
