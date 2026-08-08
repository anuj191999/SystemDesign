package question.parkingLot.payment.processor;

import question.parkingLot.payment.PaymentResult;
import question.parkingLot.payment.method.PaymentMethod;

public interface PaymentProcessor {
    PaymentResult pay(double amount, PaymentMethod method);
}
