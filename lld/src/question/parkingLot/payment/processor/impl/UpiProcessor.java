package question.parkingLot.payment.processor.impl;

import question.parkingLot.payment.PaymentResult;
import question.parkingLot.payment.PaymentStatus;
import question.parkingLot.payment.PaymentType;
import question.parkingLot.payment.method.PaymentMethod;
import question.parkingLot.payment.method.impl.UpiPayment;
import question.parkingLot.payment.processor.PaymentProcessor;

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
