package HotelRoomBookingSystem.HotelEntity;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private String floorId;
    private List<Room> rooms;

    public Floor(String floorId) {
        this.floorId = floorId;
        rooms = new ArrayList<Room>();
    }

    public String getFloorId() {
        return floorId;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorId='" + floorId + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
