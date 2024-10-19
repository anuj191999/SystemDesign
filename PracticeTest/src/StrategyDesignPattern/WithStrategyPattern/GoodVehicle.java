package WithStrategyPattern;

import WithStrategyPattern.Strategy.NormalDriveStrategy;

public class GoodVehicle extends Vehicle {

    GoodVehicle() {
        super(new NormalDriveStrategy());
    }
}
