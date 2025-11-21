package DesignPattern.BehaviouralPatterns.StatePattern.solution;

public class Walking implements TransportationModes {

    @Override
    public int getETA() {
        System.out.println("Calculating ETA (Walking)");
        return 10;
    }

    @Override
    public String getDirection() {
        return "Directions for Walking";
    }
}
