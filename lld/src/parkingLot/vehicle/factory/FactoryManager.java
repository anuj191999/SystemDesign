package parkingLot.vehicle.factory;

import parkingLot.vehicle.Vehicle;
import parkingLot.vehicle.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class FactoryManager {
    private static final Map<VehicleType, VehicleFactory> factoryMap = new HashMap<>();

    static {
        factoryMap.put(VehicleType.BIKE, new BikeFactory());
        factoryMap.put(VehicleType.CAR, new CarFactory());
        factoryMap.put(VehicleType.TRUCK, new TruckFactory());
    }

    public static Vehicle getVehicle(VehicleType type, String plateNumber) {
        VehicleFactory factory = factoryMap.get(type);
        if (factory == null) {
            throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
        return factory.createVehicle(plateNumber);
    }
}

