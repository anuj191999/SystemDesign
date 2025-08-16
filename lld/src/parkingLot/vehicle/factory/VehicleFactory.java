package parkingLot.vehicle.factory;

import parkingLot.vehicle.Vehicle;

public interface VehicleFactory {
    Vehicle createVehicle(String plateNumber);
}
