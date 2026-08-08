package question.parkingLot.vehicle.factory;

import question.parkingLot.vehicle.Car;
import question.parkingLot.vehicle.Vehicle;

public class CarFactory implements VehicleFactory{

    @Override
    public Vehicle createVehicle(String plateNumber) {
        return new Car(plateNumber);
    }
}
