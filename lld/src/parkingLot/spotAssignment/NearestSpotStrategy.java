package parkingLot.spotAssignment;

import parkingLot.parking.ParkingFloor;
import parkingLot.parking.ParkingLot;
import parkingLot.parking.ParkingSpot;
import parkingLot.vehicle.Vehicle;

import java.util.Optional;

public class NearestSpotStrategy implements SpotAssignmentStrategy{

    @Override
    public Optional<ParkingSpot> assign(ParkingLot lot, Vehicle vehicle) {
        for (ParkingFloor floor : lot.getFloors()) {
            Optional<ParkingSpot> spot = floor.findAvailable(vehicle.getType());
            if (spot.isPresent()) {
                return spot;
            }
        }
        return Optional.empty();
    }
}
