package elevator.dispatcher;

import elevator.ElevatorCar;
import elevator.controller.ElevatorController;

import java.util.List;

public class InternalDispatcher {
    private List<ElevatorController> elevatorControllerList;

    public void setElevatorControllerList(List<ElevatorController> elevatorControllerList) {
        this.elevatorControllerList = elevatorControllerList;
    }

    public void submitInternalRequest(int floor, ElevatorCar elevatorCar){
        // it will pass to elevator controller;
    }
}
