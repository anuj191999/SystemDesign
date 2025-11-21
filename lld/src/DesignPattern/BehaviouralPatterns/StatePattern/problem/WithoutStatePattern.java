package DesignPattern.BehaviouralPatterns.StatePattern.problem;

public class WithoutStatePattern{

    public static void main(String[] args){
        DirectionService directionService=new DirectionService(TransportationMode.TRAIN);
        directionService.setMode(TransportationMode.CYCLING);
        System.out.println(directionService.getDirection());
        directionService.getETA();
    }
}