package DesignPattern.BehaviouralPatterns.StatePattern.solution;

public class Train implements TransportationModes {

    @Override
    public int getETA() {
        System.out.println("Calculating ETA (Train) ");
        return 7;
    }

    @Override
    public String getDirection() {
        return "Directions for train route";
    }
}
