package question.RideSharing.strategy;

import question.RideSharing.enums.RideType;
import question.RideSharing.strategy.impl.BikeFareStrategy;
import question.RideSharing.strategy.impl.PremiumFareStrategy;
import question.RideSharing.strategy.impl.SedanFareStrategy;
import question.RideSharing.strategy.impl.XLFareStrategy;

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
