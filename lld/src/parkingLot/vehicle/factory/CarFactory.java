package parkingLot.vehicle.factory;

import parkingLot.vehicle.Car;
import parkingLot.vehicle.Vehicle;

public class CarFactory implements VehicleFactory{

    @Override
    public Vehicle createVehicle(String plateNumber) {
        return new Car(plateNumber);
    }
}
