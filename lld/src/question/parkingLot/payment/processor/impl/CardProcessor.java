package question.parkingLot.payment.processor.impl;

import question.parkingLot.payment.PaymentResult;
import question.parkingLot.payment.PaymentStatus;
import question.parkingLot.payment.PaymentType;
import question.parkingLot.payment.method.PaymentMethod;
import question.parkingLot.payment.method.impl.CardPayment;
import question.parkingLot.payment.processor.PaymentProcessor;

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
