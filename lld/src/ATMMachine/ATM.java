package ATMMachine;

import ATMMachine.ATMStates.ATMState;
import ATMMachine.ATMStates.IdleState;

public class ATM {

    private static ATM atmObject=new ATM();
    ATMState currentATMState;

    private int atmBalance;
    private int noOfTwoThousandNotes;
    private int noOfFiveHundredNotes;
    private int noOfOneHundredNotes;

    private ATM(){

    }

    public void setCurrentATMState(ATMState currentATMState){
        this.currentATMState=currentATMState;
    }
    public ATMState getCurrentATMState(){
        return currentATMState;
    }

    public int getAtmBalance(){
        return atmBalance;
    }
    public void setAtmBalance(int atmBalance,int noOfTwoThousandNotes,int noOfFiveHundredNotes,int noOfOneHundredNotes){
        this.atmBalance=atmBalance;
        this.noOfTwoThousandNotes=noOfTwoThousandNotes;
        this.noOfOneHundredNotes=noOfOneHundredNotes;
        this.noOfFiveHundredNotes=noOfFiveHundredNotes;
    }
    public static  ATM getATMObject(){
        atmObject.setCurrentATMState(new IdleState());
        return atmObject;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void deductATMBalance(int amount){
        atmBalance=atmBalance-amount;
    }

    public void deductTwoThousandNotes(int number){
        this.noOfTwoThousandNotes-=number;
    }
    public void deductFiveHundredNotes(int number){
        this.noOfFiveHundredNotes-=number;
    }
    public void deductOneHundredNotes(int number){
        this.noOfOneHundredNotes-=number;
    }

    public void printCurrentATMStatus(){
        System.out.println("Balance: "+atmBalance);
        System.out.println("2kNotes: "+noOfTwoThousandNotes);
        System.out.println("500Notes: "+noOfFiveHundredNotes);
        System.out.println("100Notes: "+noOfOneHundredNotes);
    }

}
