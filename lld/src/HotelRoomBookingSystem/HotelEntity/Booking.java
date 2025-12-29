package HotelRoomBookingSystem.HotelEntity;

import java.time.Duration;
import java.time.LocalDateTime;

public class Booking {

    private LocalDateTime  checkIn;
    private LocalDateTime checkOut;
    private double roomPrice;

    public Booking(LocalDateTime  checkin, LocalDateTime  checkout,double roomPrice) {
        this.checkIn = checkin;
        this.checkOut = checkout;
        this.roomPrice=roomPrice;
    }

    public boolean overlaps(LocalDateTime from, LocalDateTime to) {
        return from.isBefore(checkOut) && to.isAfter(checkIn);
    }

    public boolean canBeCancelled() {
        LocalDateTime now = LocalDateTime.now();
        return now.plusHours(24).isBefore(checkIn);
    }

    public boolean isAllowedToCheckIn(){
        LocalDateTime now=LocalDateTime.now();
        return now.isAfter(checkIn) && now.isBefore(checkOut);
    }

    public double getTotalFare() {
        if (checkIn == null) {
            throw new IllegalStateException("Check-in missing");
        }

        LocalDateTime effectiveCheckout =
                (checkOut == null || LocalDateTime.now().isAfter(checkOut))
                        ? LocalDateTime.now()
                        : checkOut;

        if (effectiveCheckout.isBefore(checkIn)) {
            throw new IllegalArgumentException("Invalid dates");
        }

        long minutes = Duration.between(checkIn, effectiveCheckout).toMinutes();
        long days = (long) Math.ceil(minutes / 1440.0); // extra day if crossed

        return days * roomPrice;
    }


}
