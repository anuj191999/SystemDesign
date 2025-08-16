package parkingLot.payment.processor.impl;

import parkingLot.payment.PaymentResult;
import parkingLot.payment.PaymentStatus;
import parkingLot.payment.PaymentType;
import parkingLot.payment.method.PaymentMethod;
import parkingLot.payment.method.impl.CardPayment;
import parkingLot.payment.processor.PaymentProcessor;

import java.util.UUID;

public class CashProcessor implements PaymentProcessor {
    @Override
    public PaymentResult pay(double amount, PaymentMethod method) {

        if(!method.getType().equals(PaymentType.CASH)){
            return new PaymentResult(null,"Invalid Payment method", PaymentStatus.FAILED);
        }

        return new PaymentResult(UUID.randomUUID().toString(),"Cash Received",PaymentStatus.SUCCESS);
    }
}
