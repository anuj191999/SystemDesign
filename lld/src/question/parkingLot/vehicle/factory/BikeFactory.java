package question.parkingLot.vehicle.factory;

import question.parkingLot.vehicle.Bike;
import question.parkingLot.vehicle.Vehicle;

public class BikeFactory implements  VehicleFactory{
    
    @Override
    public Vehicle createVehicle(String plateNumber) {
        return new Bike(plateNumber);
    }
}
