package question.parkingLot.payment.processor.impl;

import question.parkingLot.payment.PaymentResult;
import question.parkingLot.payment.PaymentStatus;
import question.parkingLot.payment.PaymentType;
import question.parkingLot.payment.method.PaymentMethod;
import question.parkingLot.payment.processor.PaymentProcessor;

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
