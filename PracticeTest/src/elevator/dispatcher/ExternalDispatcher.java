package elevator.dispatcher;

import elevator.Direction;
import elevator.controller.ElevatorController;

import java.util.List;

public class ExternalDispatcher {

    List<ElevatorController> elevatorControllerList;

    public void setElevatorControllerList(List<ElevatorController> elevatorControllerList) {
        this.elevatorControllerList = elevatorControllerList;
    }

    public void submitExternalRequest(int floor, Direction direction) {

        // I am following even odd algo;
        for (ElevatorController elevatorController : elevatorControllerList) {
            // i will pass send the request to controller
            int elevatorId=elevatorController.getElevatorCar().getId();
            if(elevatorId%2==1 && floor%2==1) {
                elevatorController.submitExternalRequest(floor, direction);
            }
            else if(elevatorId%2==0 && floor%2==0) {
                elevatorController.submitExternalRequest(floor, direction);
            }

        }
    }
}
