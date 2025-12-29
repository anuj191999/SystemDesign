package HotelRoomBookingSystem.HotelEntity;

public class RandomNumberGenerator {
    public static String getId() {
        int min = 100000;
        int max = 999999;
        int number = (int)(Math.random() * (max - min + 1) + min);
        return String.valueOf(number);
    }
}
