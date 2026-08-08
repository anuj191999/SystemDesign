package question.parkingLot.payment.method.impl;

import question.parkingLot.payment.PaymentType;
import question.parkingLot.payment.method.PaymentMethod;

public class UpiPayment implements PaymentMethod {
    private String upiId;
    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public PaymentType getType() {
        return PaymentType.UPI;
    }
    public String getUpiId() {
        return upiId;
    }

}
