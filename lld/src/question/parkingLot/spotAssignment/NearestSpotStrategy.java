package question.parkingLot.spotAssignment;

import question.parkingLot.parking.ParkingFloor;
import question.parkingLot.parking.ParkingLot;
import question.parkingLot.parking.ParkingSpot;
import question.parkingLot.vehicle.Vehicle;

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
