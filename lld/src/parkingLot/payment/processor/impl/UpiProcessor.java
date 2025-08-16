package parkingLot.payment.processor.impl;

import parkingLot.payment.PaymentResult;
import parkingLot.payment.PaymentStatus;
import parkingLot.payment.PaymentType;
import parkingLot.payment.method.PaymentMethod;
import parkingLot.payment.method.impl.UpiPayment;
import parkingLot.payment.processor.PaymentProcessor;

import java.util.UUID;

public class UpiProcessor implements PaymentProcessor {

    @Override
    public PaymentResult pay(double amount, PaymentMethod method) {
       if(!method.getType().equals(PaymentType.UPI)){
           return new PaymentResult(null,"Invalid Payment method", PaymentStatus.FAILED);
       }

       UpiPayment upiPayment = (UpiPayment) method;

       if(!upiPayment.getUpiId().contains("@")){
           return new PaymentResult(null,"Invalid upi ID", PaymentStatus.FAILED);
       }
       return new PaymentResult(UUID.randomUUID().toString(),"UPI transaction Successful",PaymentStatus.SUCCESS);
    }
}
