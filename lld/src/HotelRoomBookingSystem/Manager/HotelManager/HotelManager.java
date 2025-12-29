package HotelRoomBookingSystem.Manager.HotelManager;

import HotelRoomBookingSystem.HotelEntity.BookedInfo;

import java.time.LocalDateTime;
import java.util.Date;

public interface HotelManager{

    BookedInfo reservedRoom(int roomId, LocalDateTime from, LocalDateTime to);
    void cancelRoomBooking(BookedInfo bookedInfo);
    void checkIn(BookedInfo bookedInfo);
    void checkIn();
    void checkOut(BookedInfo bookedInfo);


}
