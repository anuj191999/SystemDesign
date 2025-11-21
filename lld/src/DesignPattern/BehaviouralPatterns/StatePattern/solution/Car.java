package DesignPattern.BehaviouralPatterns.StatePattern.solution;

public class Car implements TransportationModes {

    @Override
    public int getETA() {
        System.out.println("Calculating ETA (Car)");
        return 3;
    }

    @Override
    public String getDirection() {
        return "Direction for driving";
    }
}
