package DesignPattern.BehaviouralPatterns.strategyPattern;

public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.setPaymentStrategy(new DebitCardPayment());
        paymentService.pay();
    }
}
