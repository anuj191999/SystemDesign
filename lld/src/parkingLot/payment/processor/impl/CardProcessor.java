package parkingLot.payment.processor.impl;

import parkingLot.payment.PaymentResult;
import parkingLot.payment.PaymentStatus;
import parkingLot.payment.PaymentType;
import parkingLot.payment.method.PaymentMethod;
import parkingLot.payment.method.impl.CardPayment;
import parkingLot.payment.processor.PaymentProcessor;

import java.util.UUID;

public class CardProcessor implements PaymentProcessor {

    @Override
    public PaymentResult pay(double amount, PaymentMethod method) {

        if(!method.getType().equals(PaymentType.CARD)){
            return new PaymentResult(null,"Invalid Payment Method",PaymentStatus.FAILED);
        }

        CardPayment card=(CardPayment)method;
        if(card.getCardNumber().length()<8){
            return new PaymentResult(null,"Invalid Card Number",PaymentStatus.FAILED);
        }
        /*
           our payment logic will be her
         */
        return new PaymentResult(UUID.randomUUID().toString(),"Card payment approved",PaymentStatus.SUCCESS);
    }
}
