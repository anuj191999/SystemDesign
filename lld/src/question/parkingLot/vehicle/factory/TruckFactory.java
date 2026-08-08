package question.parkingLot.vehicle.factory;

import question.parkingLot.vehicle.Truck;
import question.parkingLot.vehicle.Vehicle;

public class TruckFactory implements VehicleFactory{

    @Override
    public Vehicle createVehicle(String plateNumber) {
        return new Truck(plateNumber);
    }
}
