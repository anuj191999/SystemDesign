package parkingLot.pricingStrategy.impl;

import parkingLot.invoice.Ticket;
import parkingLot.pricingStrategy.PricingStrategy;

public class HourlyPricingStrategy implements PricingStrategy {

    private final double hourlyRate;

    public HourlyPricingStrategy(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }


    @Override
    public double calculatePrice(Ticket ticket, long exitTimeMillis) {
        long durationMillis = exitTimeMillis - ticket.getEntryTimeMillis();
        long hours = (long) Math.ceil(durationMillis / (1000.0 * 60 * 60));
        return hours * hourlyRate;
    }
}
