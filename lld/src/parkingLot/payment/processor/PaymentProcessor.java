package parkingLot.payment.processor;

import parkingLot.payment.PaymentResult;
import parkingLot.payment.method.PaymentMethod;

public interface PaymentProcessor {
    PaymentResult pay(double amount, PaymentMethod method);
}
