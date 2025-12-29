package HotelRoomBookingSystem.HotelEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomId;
    private RoomType roomType;
    private List<Booking> bookings;

    public Room(int roomId, RoomType roomType) {
        this.roomId = roomId;
        this.roomType = roomType;
        bookings = new ArrayList<>();
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
    public boolean isAvailable(LocalDateTime from, LocalDateTime to) {
        for (Booking booking : bookings) {
            if (booking.overlaps(from, to)) {
                return false;
            }
        }
        return true;
    }

    public BookedInfo bookRoom(LocalDateTime from, LocalDateTime to) {
        if (!isAvailable(from, to)) {
            throw new RuntimeException("Room not available for given time");
        }
        Booking booking = new Booking(from, to,PriceUtil.getPrice(this.getRoomType()));
        bookings.add(booking);
        return new BookedInfo(RandomNumberGenerator.getId(),this.getRoomId(),booking);
    }


    public void cancelBooking(Booking booking) {
        if(!bookings.contains(booking)){
            throw new RuntimeException("Booking doesn't belong to Room");
        }
        if(booking.canBeCancelled()){
            bookings.remove(booking);
        }
        throw  new RuntimeException("Booking can't be cancelled");
    }
    public boolean verifyBooking(Booking booking){
        if(!bookings.contains(booking)){
            throw new RuntimeException("Booking doesn't belong to Room");
        }
        return booking.isAllowedToCheckIn();
    }
    public boolean startCheckOut(Booking booking){
        boolean isValid= bookings.contains(booking);
        bookings.remove(booking);
        return isValid;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomType=" + roomType +
                '}';
    }
}
