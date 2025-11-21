package DesignPattern.CreationalPatterns.FactoryPatterns.solution;


public class TransportService {
    public static void main(String[] args) {
        Transport bike = TransportFactory.createTransport("bike");
        Transport car = TransportFactory.createTransport("car");

        bike.drive();
        car.drive();
    }
}
