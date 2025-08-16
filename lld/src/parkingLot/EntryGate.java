package parkingLot;

import parkingLot.invoice.Ticket;
import parkingLot.invoice.TicketSatus;
import parkingLot.parking.ParkingFloor;
import parkingLot.parking.ParkingLot;
import parkingLot.parking.ParkingSpot;
import parkingLot.spotAssignment.SpotAssignmentStrategy;
import parkingLot.vehicle.Vehicle;
import parkingLot.vehicle.VehicleType;
import parkingLot.vehicle.factory.FactoryManager;

import java.util.Optional;
import java.util.UUID;

public class EntryGate {

    private final ParkingLot parkingLot;

    public EntryGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }


    public Ticket parkedVehicle(String plateNumber, VehicleType vehicleType){
        Vehicle vehicle= FactoryManager.getVehicle(vehicleType,plateNumber);
        Optional<ParkingSpot> spot=parkingLot.assignSpot(vehicle);
        spot.ifPresent(ParkingSpot::occupy);
        return new Ticket(UUID.randomUUID().toString(),vehicle,spot.get(),System.currentTimeMillis(), TicketSatus.ACTIVE);
    }
}
