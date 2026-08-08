            **Parking Lot**
======================================================================

Set up

The parking lot has multiple slots available for vehicles
Different vehicle type (Bike, Car, Truck) occupy different slot size
Each vehicle get a parking ticket upon entry
The system calculates the parking fee based on duration of stay and vehicle type

Exit and payment 

A vehicle must complete payment before exiting 
multiple payment methods are supports (cash UPI, card)
once payment done the exits and slot is freed.

Illegal Action 

A vehicle can't park in an already occupied slot
vehicle can't vacate without payment



Entity

Vehicle 

Parking Lot 
it has slots
Responsible 
   Allocating and releasing parking slots
   Tracking occupied and free slots

Parking Slot
 vehicleType slotType,
isOccupied
