package DesignPattern.CreationalPatterns.FactoryPatterns.problem;

public class TransportService {
    public static void main(String[] args) {
        Bike bike = new Bike();
        Car car = new Car();

        bike.drive();
        car.drive();
    }
}
