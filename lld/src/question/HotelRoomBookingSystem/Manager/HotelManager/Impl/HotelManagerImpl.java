package question.HotelRoomBookingSystem.Manager.HotelManager.Impl;

import question.HotelRoomBookingSystem.HotelEntity.BookedInfo;
import question.HotelRoomBookingSystem.HotelEntity.Hotel;
import question.HotelRoomBookingSystem.Manager.HotelManager.HotelManager;

import java.time.LocalDateTime;

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
