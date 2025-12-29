package HotelRoomBookingSystem.Manager.HotelManager.Impl;

import HotelRoomBookingSystem.HotelEntity.BookedInfo;
import HotelRoomBookingSystem.HotelEntity.Hotel;
import HotelRoomBookingSystem.Manager.HotelManager.HotelManager;

import java.time.LocalDateTime;
import java.util.Date;

public class HotelManagerImpl implements HotelManager {

    private Hotel hotel;

    public HotelManagerImpl(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public BookedInfo reservedRoom(int roomId, LocalDateTime from, LocalDateTime to) {
        return hotel.reserveRoom(roomId, from, to);
    }

    @Override
    public void cancelRoomBooking(BookedInfo bookedInfo) {
        hotel.cancelBooking(bookedInfo);
    }

    @Override
    public void checkIn(BookedInfo bookedInfo) {
        hotel.checkIn(bookedInfo);
    }

    @Override
    public void checkIn() {
        /**
         * I will placed room reservation at run time and will pass the bookedInfo to hotel-checkin method
         */
    }

    @Override
    public void checkOut(BookedInfo bookedInfo) {
        hotel.checkOut(bookedInfo);
    }
}
