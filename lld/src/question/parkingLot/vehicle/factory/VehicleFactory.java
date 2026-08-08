package question.parkingLot.vehicle.factory;

import question.parkingLot.vehicle.Vehicle;

public interface VehicleFactory {
    Vehicle createVehicle(String plateNumber);
}
