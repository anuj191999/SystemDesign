package libraryManagement.calculation;

import libraryManagement.member.MemberRole;

import java.util.HashMap;
import java.util.Map;

public class CalculationFactory {
    private static final Map<MemberRole,CalculationStrategy> calculationStrategyMap = new HashMap<>();
    static {
        calculationStrategyMap.put(MemberRole.STUDENT,new GenericCalculationStrategy(5,10,2.0));
        calculationStrategyMap.put(MemberRole.FACULTY,new GenericCalculationStrategy(10,14,1.0));
    }
    public static CalculationStrategy getCalculationStrategy(MemberRole role){
        return calculationStrategyMap.get(role);
    }
}
