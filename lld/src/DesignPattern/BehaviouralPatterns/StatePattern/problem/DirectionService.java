package DesignPattern.BehaviouralPatterns.StatePattern.problem;

enum TransportationMode{
    WALKING,
    CYCLING,
    CAR,
    TRAIN;
}

public class DirectionService {

    private TransportationMode mode;

    public DirectionService(TransportationMode mode) {
        this.mode = mode;
    }
    public void setMode(TransportationMode mode) {
        this.mode = mode;
    }

    public int getETA(){

        switch (mode){
            case WALKING:
                System.out.println("Calc ETA for walking 10");
                return 10;
            case CYCLING:
                System.out.println("Calc ETA for cycling 5");
                return 5;
            case CAR:
                System.out.println("Calc ETA for car 2");
                return 2;
            case TRAIN:
                System.out.println("Calc ETA for car 3");
                return 3;
            default:
                throw new IllegalArgumentException("Invalid TransportationMode");
        }
    }

    public String getDirection(){
        return switch (mode) {
            case WALKING -> "Direction for walking : Head north for 500 meters.";
            case CYCLING -> "Direction for cycling : Take the bike lane on Elm Street";
            case CAR -> "Direction for car : use highway 50m towards downtown";
            case TRAIN -> "Direction for Train: Board the Red line at central Station";
            default -> "no direction available for the selected mode.";
        };
    }
}
