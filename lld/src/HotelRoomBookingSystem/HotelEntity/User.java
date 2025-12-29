package HotelRoomBookingSystem.HotelEntity;

public class User {
    private String id;
    private String name;
    private String mobNumber;

    public User(String id, String name, String mobNumber) {
        this.id = id;
        this.name = name;
        this.mobNumber = mobNumber;
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

    public String getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(String mobNumber) {
        this.mobNumber = mobNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", mobNumber='" + mobNumber + '\'' +
                '}';
    }
}
