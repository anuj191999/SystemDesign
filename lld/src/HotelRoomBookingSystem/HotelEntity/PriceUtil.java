package HotelRoomBookingSystem.HotelEntity;

public class PriceUtil {
    public static double getPrice(RoomType type) {
        switch (type) {
            case SINGLE -> { return 500.0; }
            case DOUBLE -> { return 1000.0; }
            case TRIPLE -> { return 1500.0; }
            default -> throw new IllegalArgumentException("Invalid room type");
        }
    }

}
