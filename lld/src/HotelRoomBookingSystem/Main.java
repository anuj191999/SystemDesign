package HotelRoomBookingSystem;

import HotelRoomBookingSystem.HotelEntity.Floor;
import HotelRoomBookingSystem.HotelEntity.Hotel;
import HotelRoomBookingSystem.HotelEntity.Room;
import HotelRoomBookingSystem.HotelEntity.RoomType;
import HotelRoomBookingSystem.Manager.HotelManager.HotelManager;
import HotelRoomBookingSystem.Manager.HotelManager.Impl.HotelManagerImpl;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Main main=new Main();
        Hotel tajHotel=main.setUpHotel();
        tajHotel.displayAllRooms();
        HotelManager manager=new HotelManagerImpl(tajHotel);

//        manager.reservedRoom(101, LocalDateTime.now(),LocalDateTime.)
    }

    public Hotel setUpHotel(){

        // Preparing Room
        Room room1=new Room(101, RoomType.SINGLE);
        Room room2=new Room(102,RoomType.DOUBLE);
        Room room3=new Room(103,RoomType.TRIPLE);
        Room room4=new Room(201, RoomType.SINGLE);
        Room room5=new Room(202,RoomType.DOUBLE);
        Room room6=new Room(203,RoomType.TRIPLE);

        // Set-up the first floor
        Floor f1=new Floor("f1");
        f1.addRoom(room1);
        f1.addRoom(room2);
        f1.addRoom(room3);

        // set-up the second floor

        Floor f2=new Floor("f1");
        f2.addRoom(room4);
        f2.addRoom(room5);
        f2.addRoom(room6);

        Hotel tajHotel=new Hotel("Taj-101","Taj Hotel Mumbai",Arrays.asList(f1,f2),"Delhi");
//        tajHotel.addFloor(f1);
//        tajHotel.addFloor(f2);
        return tajHotel;

    }
}
