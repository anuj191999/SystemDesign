package DesignPattern.BehaviouralPatterns.StatePattern.solution;

public class DirectionService {

    private TransportationModes mode;
    public DirectionService(TransportationModes mode) {
        this.mode = mode;
    }

    public String getDirection() {
        return mode.getDirection();
    }

    public int getETA(){
        return mode.getETA();
    }
}
