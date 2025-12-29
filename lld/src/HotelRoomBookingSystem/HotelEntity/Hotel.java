package HotelRoomBookingSystem.HotelEntity;

import java.time.LocalDateTime;
import java.util.List;

public class Hotel {
    private String id;
    private String name;
    private List<Floor> floorList;
    private String location;

    public Hotel(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Hotel(String id, String name, List<Floor> floorList, String location) {
        this.id = id;
        this.name = name;
        this.floorList = floorList;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void addFloor(Floor floor) {
        this.floorList.add(floor);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private Room getRoom(int roomId){
        for(Floor floor : floorList){
            for(Room room : floor.getRooms()){
                if(room.getRoomId() == roomId){
                    return room;
                }
            }
        }
        return null;
    }

    public BookedInfo reserveRoom(int roomId, LocalDateTime from,LocalDateTime to) {
        Room room = getRoom(roomId);
        assert room != null;
        BookedInfo info=room.bookRoom(from,to);
        System.out.println("Congrats your booking has been placed : "+info.toString());
        return info;
    }

    public void cancelBooking(BookedInfo bookedInfo) {
        Room room=getRoom(bookedInfo.getRoomNo());
        assert room != null;
        room.cancelBooking(bookedInfo.getBooking());
        System.out.println("Your Booking has been canceled");
    }

    public void  checkIn(BookedInfo bookedInfo) {
        Room room=getRoom(bookedInfo.getRoomNo());
        assert room != null;
        if(room.verifyBooking(bookedInfo.getBooking())){
            System.out.println("Congrats you have successfully checked-in our hotel");
        }
        else{
            System.out.println("Sorry !! you are not allowed to check-in, Please connect with our manager");
        }

    }

    public void checkOut(BookedInfo bookedInfo){
        Room room=getRoom(bookedInfo.getRoomNo());
        assert room!=null;
        if(room.startCheckOut(bookedInfo.getBooking())){
            double finalFare=bookedInfo.getBooking().getTotalFare();
            System.out.println("Thanks for Choosing us :: your final fare is "+finalFare);
        }


    }

    public void displayAllRooms(){
        for(Floor floor:floorList){
            System.out.println(floor.toString());
        }
    }
    @Override
    public String toString() {
        return "Hotel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", floorList=" + floorList +
                ", location='" + location + '\'' +
                '}';
    }
}
