package ATMMachine.AmountWithdrawal;


import ATMMachine.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawalProcessor {

    public OneHundredWithdrawProcessor(CashWithdrawalProcessor nextProcessor) {
        super(nextProcessor);
    }


    public void withdraw(ATM atm, int remainingAmount){

        int required =  remainingAmount/100;
        int balance = remainingAmount%100;

        if(required <= atm.getNoOfOneHundredNotes()) {
            atm.deductOneHundredNotes(required);
        }
        else if(required > atm.getNoOfOneHundredNotes()) {
            balance = balance + (required-atm.getNoOfOneHundredNotes()) * 100;
            atm.deductOneHundredNotes(atm.getNoOfOneHundredNotes());
        }

        if(balance != 0){
            System.out.println("Something went wrong");
        }
    }

}
