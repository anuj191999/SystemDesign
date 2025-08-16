package parkingLot;


import parkingLot.invoice.Ticket;
import parkingLot.parking.ParkingFloor;
import parkingLot.parking.ParkingLot;
import parkingLot.parking.ParkingSpot;
import parkingLot.payment.method.impl.CashPayment;
import parkingLot.payment.processor.impl.CardProcessor;
import parkingLot.payment.processor.impl.CashProcessor;
import parkingLot.pricingStrategy.impl.HourlyPricingStrategy;
import parkingLot.spotAssignment.NearestSpotStrategy;
import parkingLot.vehicle.VehicleType;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=======Welcome to My Parking Lot======");
        ParkingFloor parkingFloor1=new ParkingFloor("f1",
                Arrays.asList(
                        new ParkingSpot("s1", VehicleType.BIKE),
                        new ParkingSpot("s2", VehicleType.CAR),
                        new ParkingSpot("s3",VehicleType.TRUCK)
                )

        );
        ParkingFloor parkingFloor2=new ParkingFloor("f2",
                Arrays.asList(
                        new ParkingSpot("s1", VehicleType.BIKE),
                        new ParkingSpot("s2", VehicleType.CAR),
                        new ParkingSpot("s3",VehicleType.TRUCK)
                )

        );
        ParkingFloor parkingFloor3=new ParkingFloor("f3",
                Arrays.asList(
                        new ParkingSpot("s1", VehicleType.BIKE),
                        new ParkingSpot("s2", VehicleType.CAR),
                        new ParkingSpot("s3",VehicleType.TRUCK)
                )

        );
        ParkingLot parkingLot=new ParkingLot(
                Arrays.asList(parkingFloor1,parkingFloor2,parkingFloor3),
                new NearestSpotStrategy()
        );
        // Created Object for Entry Gate and assigned assigned Parking lot
        EntryGate entryGate=new EntryGate(parkingLot);

        ExitGate exitGate=new ExitGate(new HourlyPricingStrategy(20.0));

//        parkingLot.displayAllLot();
        Scanner sc=new Scanner(System.in);
//        while(true){
            System.out.println("Enter your Vehicle Number and Type");
            String vehicleNumber= sc.nextLine();
            String type=sc.nextLine();
            System.out.println("Before Allocation:: ");
            parkingLot.displayAllLot();
            Ticket ticket=entryGate.parkedVehicle(vehicleNumber, VehicleType.valueOf(type));
            System.out.println("After Allocation::");
            parkingLot.displayAllLot();
            System.out.println(ticket.toString());
            Thread.sleep(4000);
            exitGate.processExit(ticket,new CashPayment(), new CashProcessor());
            System.out.println("After Exit Vehicle");
            parkingLot.displayAllLot();
//            break;
//        }
    }
}
