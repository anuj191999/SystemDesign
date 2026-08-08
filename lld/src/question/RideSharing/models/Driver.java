package question.RideSharing.models;

import question.RideSharing.enums.DriverStatus;
import question.RideSharing.enums.RideType;

public class Driver {

    private final String id;
    private final String name;
    private final String phone;
    private final RideType vehicleType;

    private Location currentLocation;
    private DriverStatus status;
    private double rating;

    public Driver(String id, String name, String phone, RideType vehicleType, Location currentLocation) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.vehicleType = vehicleType;
        this.currentLocation = currentLocation;
        this.status = DriverStatus.OFFLINE;
        this.rating = 5.0;
    }

    public void goOnline(){
        this.status=DriverStatus.ONLINE;
        System.out.println("Driver "+name+" is now ONLINE");
    }

    public void goOffline(){
        this.status=DriverStatus.OFFLINE;
        System.out.println("Driver "+name+" is now OFFLINE");
    }

    public void updateLocation(Location location){
        this.currentLocation=location;
        System.out.println("Driver "+name+" location updated to "+location);
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

    public RideType getVehicleType() {
        return vehicleType;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public double getRating() {
        return rating;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString(){
        return String.format("Driver[%s | %s | %s  | %s | Rating %.1f]",id,name,vehicleType,status,rating);
    }
}
