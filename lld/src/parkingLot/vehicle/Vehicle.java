package parkingLot.vehicle;

public abstract class Vehicle {
    private final String plateNumber;
    private final VehicleType vehicleType;
    public Vehicle(String plateNumber, VehicleType vehicleType) {
        this.plateNumber = plateNumber;
        this.vehicleType = vehicleType;
    }
    public String getPlateNumber() {
        return plateNumber;
    }
    public VehicleType getType() {
        return vehicleType;
    }
}
