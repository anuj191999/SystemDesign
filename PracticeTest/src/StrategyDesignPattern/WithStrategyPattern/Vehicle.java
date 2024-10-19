package WithStrategyPattern;

import WithStrategyPattern.Strategy.DriveStrategy;

public class Vehicle {
    DriveStrategy driveStrategyObject;
    Vehicle(DriveStrategy driveStrategyObject) {
        this.driveStrategyObject = driveStrategyObject;
    }
    public  void drive()
    {
        driveStrategyObject.drive();
    }
}
