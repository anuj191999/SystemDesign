package parkingLot.parking;

import parkingLot.vehicle.VehicleType;

public class ParkingSpot {
    private final String id;
    private final VehicleType supportedType;
    private boolean occupied;
    public ParkingSpot(String id, VehicleType vehicleType) {
        this.id = id;
        this.supportedType = vehicleType;
        this.occupied = false;
    }
    public String getId() {
        return id;
    }
    public boolean isOccupied() {
        return occupied;
    }
    public void occupy(){
        this.occupied = true;
    }
    public void vacate(){
        this.occupied = false;
    }
    public VehicleType getSupportedType() {
        return supportedType;
    }
}
