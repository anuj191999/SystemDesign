package DesignPattern.BehaviouralPatterns.StatePattern.solution;

public class Cycling implements TransportationModes {

    @Override
    public int getETA() {
        System.out.println("Calculating ETA (Cycling)");
        return 5;
    }

    @Override
    public String getDirection() {
        return "Direction for Cycling";
    }
}
