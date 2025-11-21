package DesignPattern.CreationalPatterns.FactoryPatterns.solution;

public class TransportFactory {

    public static Transport createTransport(String type){
        return switch (type.toLowerCase()) {
            case "car" -> new Car();
            case "bike" -> new Bike();
            case "bus" -> new Bus();
            default -> throw new IllegalArgumentException("Unsupported transport type");
        };
    }
}
