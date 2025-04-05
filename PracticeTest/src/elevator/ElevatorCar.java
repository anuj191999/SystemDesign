package elevator;

public class ElevatorCar {

    private int id;
    private ElevatorDisplay display;
    private InternalButtons internalButtons;
    private Status elevatorStatus;
    private  int currentFloor;
    private Direction elevatorDirection;
    private ElevatorDoor elevatorDoor;

    ElevatorCar(){
        display = new ElevatorDisplay();
        internalButtons = new InternalButtons();
        elevatorStatus=Status.IDLE;
        currentFloor=0;
        elevatorDirection=Direction.UP;
        elevatorDoor=new ElevatorDoor();
    }

    public int getId() {
        return id;
    }

    public ElevatorDisplay getDisplay() {
        return display;
    }

    public InternalButtons getInternalButtons() {
        return internalButtons;
    }

    public Status getElevatorStatus() {
        return elevatorStatus;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getElevatorDirection() {
        return elevatorDirection;
    }

    public ElevatorDoor getElevatorDoor() {
        return elevatorDoor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDisplay(ElevatorDisplay display) {
        this.display = display;
    }

    public void setInternalButtons(InternalButtons internalButtons) {
        this.internalButtons = internalButtons;
    }

    public void setElevatorStatus(Status elevatorStatus) {
        this.elevatorStatus = elevatorStatus;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setElevatorDirection(Direction elevatorDirection) {
        this.elevatorDirection = elevatorDirection;
    }

    public void setElevatorDoor(ElevatorDoor elevatorDoor) {
        this.elevatorDoor = elevatorDoor;
    }

    public void showDisplay(){
        display.showDisplay();
    }

    public void pressButton(int destination){
        // it will pass to internal Dispatcher; or buttons
        internalButtons.pressButton(destination,this);
    }
    public void setDisplay(){
        this.display.setDisplay(currentFloor,elevatorDirection);
    }

    boolean moveElevator(Direction dir,int destinationFloor){
        int startFloor=currentFloor;

        if(dir==Direction.UP){
            for(int i=startFloor;i<=destinationFloor;i++){
                this.currentFloor=i;
                setDisplay();
                showDisplay();
                if(i==destinationFloor){
                    return true;
                }
            }
        }

        if(dir==Direction.DOWN){
            for(int i=startFloor;i>=destinationFloor;i--){
                this.currentFloor=i;
                setDisplay();
                showDisplay();
                if(i==destinationFloor){
                    return true;
                }
            }
        }
        return false;
    }
}
