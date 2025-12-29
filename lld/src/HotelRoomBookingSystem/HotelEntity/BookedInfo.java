package HotelRoomBookingSystem.HotelEntity;

public class BookedInfo {

    String id;
    int roomNo;
    Booking booking;
    Hotel hotelName;
    String Location;

    public BookedInfo(String id, int roomNo, Booking booking) {
        this.id = id;
        this.roomNo = roomNo;
        this.booking = booking;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
