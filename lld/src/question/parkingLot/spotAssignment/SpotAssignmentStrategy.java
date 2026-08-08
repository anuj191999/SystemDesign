package question.parkingLot.spotAssignment;

import question.parkingLot.parking.ParkingLot;
import question.parkingLot.parking.ParkingSpot;
import question.parkingLot.vehicle.Vehicle;

import java.util.Optional;

public interface SpotAssignmentStrategy {
    Optional<ParkingSpot> assign(ParkingLot lot, Vehicle vehicle);
}
