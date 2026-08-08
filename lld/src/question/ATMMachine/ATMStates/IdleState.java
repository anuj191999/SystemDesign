package question.ATMMachine.ATMStates;

import question.ATMMachine.ATM;
import question.ATMMachine.Card;

public class IdleState extends ATMState{

    @Override
    public void insertCard(ATM atmObject , Card card){
        System.out.println("Card is Inserted");
        atmObject.setCurrentATMState(new HasCardState());
    }
}
