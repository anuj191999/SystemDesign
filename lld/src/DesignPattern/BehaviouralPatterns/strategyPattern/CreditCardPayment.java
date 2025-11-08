package DesignPattern.BehaviouralPatterns.strategyPattern;

public class CreditCardPayment implements PaymentStrategy {

    @Override
    public void processPayment() {
        System.out.println("Making payment via credit card");
    }
}
