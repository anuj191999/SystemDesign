package parkingLot.payment.method.impl;

import parkingLot.payment.PaymentType;
import parkingLot.payment.method.PaymentMethod;

public class CashPayment implements PaymentMethod {

    @Override
    public PaymentType getType() {
        return PaymentType.CASH;
    }
}
