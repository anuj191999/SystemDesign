package elevator;

import elevator.dispatcher.InternalDispatcher;

public class InternalButtons {
    private InternalDispatcher dispatcher=new InternalDispatcher();
    int [] availableButtons ={1,2,3,4,5,6,7,8,9};
    int buttonSelected;

    public void pressButton(int destination,ElevatorCar elevatorCar){

        dispatcher.submitInternalRequest(destination,elevatorCar);
    }
}
