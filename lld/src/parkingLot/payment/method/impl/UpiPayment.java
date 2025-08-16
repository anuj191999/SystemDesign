package parkingLot.payment.method.impl;

import parkingLot.payment.PaymentType;
import parkingLot.payment.method.PaymentMethod;

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
