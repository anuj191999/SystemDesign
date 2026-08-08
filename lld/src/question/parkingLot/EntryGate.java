package question.parkingLot;

import question.parkingLot.invoice.Ticket;
import question.parkingLot.invoice.TicketSatus;
import question.parkingLot.parking.ParkingLot;
import question.parkingLot.parking.ParkingSpot;
import question.parkingLot.vehicle.Vehicle;
import question.parkingLot.vehicle.VehicleType;
import question.parkingLot.vehicle.factory.FactoryManager;

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
