package question.RideSharing.models;

public class Rider {

    private final String id;
    private final String name;
    private final String phone;
    private Location currentLocation;
    private double rating;

    public Rider(String id, String name, String phone, Location currentLocation) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.currentLocation = currentLocation;
        this.rating = 5.0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public double getRating() {
        return rating;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString(){
        return String.format("Rider[%s | %s | Rating: %.1f",id,name,rating);
    }
}
