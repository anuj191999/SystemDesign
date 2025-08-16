package parkingLot.vehicle.factory;

import parkingLot.vehicle.Truck;
import parkingLot.vehicle.Vehicle;

public class TruckFactory implements VehicleFactory{

    @Override
    public Vehicle createVehicle(String plateNumber) {
        return new Truck(plateNumber);
    }
}
