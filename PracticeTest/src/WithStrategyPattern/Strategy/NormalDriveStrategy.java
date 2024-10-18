package WithStrategyPattern.Strategy;

public class NormalDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {

        System.out.println("NormalDriveStrategy");
    }
}
