package question.ATMMachine.ATMStates;

import question.ATMMachine.ATM;
import question.ATMMachine.Card;

public class CheckBalanceState extends ATMState {

    @Override
    public void displayBalance(ATM atmObject, Card card){
        System.out.println("Your Balance is : "+card.getBankBalance());
        exit(atmObject);
    }

    @Override
    public void exit(ATM atmObject){
        returnCard();
        atmObject.setCurrentATMState(null);
        System.out.println("Exit Happens");
    }

    public void returnCard(){
        System.out.println("Please collect your card");
    }

}
