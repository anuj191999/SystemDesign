package DesignPattern.BehaviouralPatterns.StatePattern.solution;


public class WithStatePattern {
    public static void main(String[] args) {
        DirectionService service=new DirectionService(new Car());
        System.out.println("ETA: " + service.getETA());
        System.out.println("Direction: " + service.getDirection());

    }
}
