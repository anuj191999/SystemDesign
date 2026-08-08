package question.parkingLot.payment.method.impl;

import question.parkingLot.payment.PaymentType;
import question.parkingLot.payment.method.PaymentMethod;

public class CashPayment implements PaymentMethod {

    @Override
    public PaymentType getType() {
        return PaymentType.CASH;
    }
}
