package question.HotelRoomBookingSystem.Manager.HotelManager;

import question.HotelRoomBookingSystem.HotelEntity.BookedInfo;

import java.time.LocalDateTime;

public interface HotelManager{

    BookedInfo reservedRoom(int roomId, LocalDateTime from, LocalDateTime to);
    void cancelRoomBooking(BookedInfo bookedInfo);
    void checkIn(BookedInfo bookedInfo);
    void checkIn();
    void checkOut(BookedInfo bookedInfo);


}
