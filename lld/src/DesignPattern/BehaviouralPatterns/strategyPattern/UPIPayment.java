package DesignPattern.BehaviouralPatterns.strategyPattern;

public class UPIPayment implements PaymentStrategy {

    @Override
    public void processPayment() {
        System.out.println("Making payment via UPI....");
    }
}
