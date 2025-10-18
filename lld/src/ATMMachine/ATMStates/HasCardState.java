package ATMMachine.ATMStates;

import ATMMachine.ATM;
import ATMMachine.Card;

public class HasCardState extends ATMState {

    public HasCardState() {
        System.out.println("Enter your card pin number");
    }

    @Override
    public void authenticatePin(ATM amtObject, Card card,int pin){
        boolean isCorrectPinEntered= card.isCorrectPINEntered(pin);
        if(isCorrectPinEntered){
            amtObject.setCurrentATMState(new SelectOperationState());
        }
        else{
            System.out.println("Invalid PIN Number");
            exit(amtObject);
        }
    }

    @Override
    public void exit(ATM amtObject){
        returnCard();
        amtObject.setCurrentATMState(new IdleState());
        System.out.println("Exit Happens");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }
}
