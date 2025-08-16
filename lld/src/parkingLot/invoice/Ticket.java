package parkingLot.invoice;

import parkingLot.parking.ParkingSpot;
import parkingLot.vehicle.Vehicle;

public class Ticket {
    private final String id;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final long entryTimeMillis;

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", vehicle Number=" + vehicle.getPlateNumber() +
                ", spot=" + spot.getId() +
                ", entryTimeMillis=" + entryTimeMillis +
                ", ticketSatus=" + ticketSatus +
                '}';
    }

    private  TicketSatus ticketSatus;

    public Ticket(String id, Vehicle vehicle, ParkingSpot spot, long entryTimeMillis, TicketSatus ticketSatus) {
        this.id = id;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTimeMillis = entryTimeMillis;
        this.ticketSatus = ticketSatus;
    }

    public String getId() { return id; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSpot getSpot() { return spot; }
    public long getEntryTimeMillis() { return entryTimeMillis; }
    public TicketSatus getTicketSatus(){
        return this.ticketSatus;
    }
    public void setTicketSatus(TicketSatus ticketSatus){
        this.ticketSatus=ticketSatus;
    }


}

