package question.parkingLot;

import question.parkingLot.invoice.Ticket;
import question.parkingLot.invoice.TicketSatus;
import question.parkingLot.payment.PaymentResult;
import question.parkingLot.payment.method.PaymentMethod;
import question.parkingLot.payment.processor.PaymentProcessor;
import question.parkingLot.pricingStrategy.PricingStrategy;

public class ExitGate {
    private final PricingStrategy pricingStrategy;

    public ExitGate(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public boolean processExit(Ticket ticket, PaymentMethod method, PaymentProcessor paymentProcessor){
        if(ticket.getTicketSatus().equals(TicketSatus.PAID)){
            System.out.println("Already Exist this vehicle");
            return false;
        }
        // calculate price;
        long exitTime=System.currentTimeMillis();
        double amount=pricingStrategy.calculatePrice(ticket,exitTime);
        System.out.println("Parking Fee: "+amount);

        // process Payment

        PaymentResult result=paymentProcessor.pay(amount,method);

        if(!result.isSuccess()){
            System.out.println("Payment failed: "+result.getMessage());
            return false;
        }

        // vacate spot

        ticket.getSpot().vacate();
        ticket.setTicketSatus(TicketSatus.PAID);
        System.out.println("Exit Successful. Transaction ID: "+result.getTransactionId());
        return  true;
    }
}
