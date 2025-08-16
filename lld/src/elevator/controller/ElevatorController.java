package elevator.controller;

import elevator.Direction;
import elevator.ElevatorCar;

import java.util.PriorityQueue;

public class ElevatorController {
    PriorityQueue<Integer> upMinPQ;
    PriorityQueue<Integer> downMinPQ;
    ElevatorCar elevatorCar;

    public ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityQueue<>();
        downMinPQ = new PriorityQueue<>((a,b)->b-a);
    }

    public void submitExternalRequest(int floor, Direction direction) {
        if(direction==Direction.UP) {
            downMinPQ.offer(floor);
        }
        else{
            upMinPQ.offer(floor);
        }
    }
    public void SubmitInternalRequest(int floor) {

    }

    public void controlElevator() {
//        while(true){
//
//        }
    }
    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }
}
