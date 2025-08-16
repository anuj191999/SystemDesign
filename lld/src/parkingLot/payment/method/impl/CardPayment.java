package parkingLot.payment.method.impl;

import parkingLot.payment.PaymentType;
import parkingLot.payment.method.PaymentMethod;

public class CardPayment implements PaymentMethod {
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private String cardHolderName;

    public CardPayment(String cardNumber, String expiryDate, String cvv, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public PaymentType getType() {
        return PaymentType.CARD;
    }

    public String getCardNumber() {
        return cardNumber;
    }
    public String getExpiryDate() {
        return expiryDate;
    }
    public String getCvv() {
        return cvv;
    }
    public String getCardHolderName() {
        return cardHolderName;
    }
}
