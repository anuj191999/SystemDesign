package parkingLot.parking;

import parkingLot.vehicle.VehicleType;

import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    private final String id;
    private List<ParkingSpot> spots;
    public ParkingFloor(String id, List<ParkingSpot> spots) {
        this.id = id;
        this.spots = spots;
    }
    public String getId() {
        return id;
    }

    public Optional<ParkingSpot> findAvailable(VehicleType type) {
        return spots.stream()
                .filter(s -> s.getSupportedType() == type && !s.isOccupied())
                .findFirst();
    }

    public List<ParkingSpot> getSpots(){
        return this.spots;
    }

}
