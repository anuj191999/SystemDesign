package RideSharing.strategy;

import RideSharing.enums.RideType;
import RideSharing.strategy.impl.BikeFareStrategy;
import RideSharing.strategy.impl.PremiumFareStrategy;
import RideSharing.strategy.impl.SedanFareStrategy;
import RideSharing.strategy.impl.XLFareStrategy;

public class FareStrategyFactory {
    public static FareStrategy getStrategy(RideType rideType){
        return  switch (rideType){
            case  BIKE -> new BikeFareStrategy();
            case SEDAN -> new SedanFareStrategy();
            case XL -> new XLFareStrategy();
            case PREMIUM -> new PremiumFareStrategy();
        };
    }
}
