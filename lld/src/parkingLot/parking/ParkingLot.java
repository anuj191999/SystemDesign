package parkingLot.parking;

import parkingLot.spotAssignment.SpotAssignmentStrategy;
import parkingLot.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public class ParkingLot {
    private final List<ParkingFloor> parkingFloors;
    private SpotAssignmentStrategy strategy;

    public ParkingLot(List<ParkingFloor> parkingFloors, SpotAssignmentStrategy strategy) {
        this.parkingFloors = parkingFloors;
        this.strategy = strategy;
    }

    public List<ParkingFloor> getFloors() {
        return parkingFloors;
    }

    public void setStrategy(SpotAssignmentStrategy strategy) {
        this.strategy = strategy;
    }
    public Optional<ParkingSpot> assignSpot(Vehicle vehicle){
        return strategy.assign(this,vehicle);
    }

    public void displayAllLot(){
        System.out.println("SpotAssignmentStrategy :: "+strategy.getClass().getName());
        parkingFloors.stream()
                .forEach(floor -> {
                    System.out.println("Floor: " + floor.getId());
                    floor.getSpots().stream()
                            .forEach(spot -> System.out.printf("   Spot: %s | Type: %s | Occupied: %s%n",
                                    spot.getId(),
                                    spot.getSupportedType(),
                                    spot.isOccupied()));
                });

    }
}
