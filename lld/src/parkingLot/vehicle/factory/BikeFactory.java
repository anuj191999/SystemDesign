package parkingLot.vehicle.factory;

import parkingLot.vehicle.Bike;
import parkingLot.vehicle.Vehicle;

public class BikeFactory implements  VehicleFactory{
    
    @Override
    public Vehicle createVehicle(String plateNumber) {
        return new Bike(plateNumber);
    }
}
