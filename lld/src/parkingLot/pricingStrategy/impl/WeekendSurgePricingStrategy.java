package parkingLot.pricingStrategy.impl;

import parkingLot.invoice.Ticket;
import parkingLot.pricingStrategy.PricingStrategy;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.ZoneId;

public class WeekendSurgePricingStrategy implements PricingStrategy {

    private final double weekdayRate;
    private final double weekendRate;

    public WeekendSurgePricingStrategy(double weekdayRate, double weekendRate) {
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
    }

    @Override
    public double calculatePrice(Ticket ticket, long exitTimeMillis) {
        Instant instant = Instant.ofEpochMilli(exitTimeMillis);
        DayOfWeek day = instant.atZone(ZoneId.systemDefault()).getDayOfWeek();

        double rate = (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY)
                ? weekendRate
                : weekdayRate;

        long durationMillis = exitTimeMillis - ticket.getEntryTimeMillis();
        long hours = (long) Math.ceil(durationMillis / (1000.0 * 60 * 60));
        return hours * rate;
    }
}
