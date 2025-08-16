package parkingLot.spotAssignment;

import parkingLot.parking.ParkingLot;
import parkingLot.parking.ParkingSpot;
import parkingLot.vehicle.Vehicle;

import java.util.Optional;

public interface SpotAssignmentStrategy {
    Optional<ParkingSpot> assign(ParkingLot lot, Vehicle vehicle);
}
