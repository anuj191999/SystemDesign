package ATMMachine.AmountWithdrawal;

import ATMMachine.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawalProcessor{

    public FiveHundredWithdrawProcessor(CashWithdrawalProcessor cashWithdrawalProcessor) {
        super(cashWithdrawalProcessor);
    }

    public void withdraw(ATM atm,int remainingAmount){
        int required=remainingAmount/500;
        int balance=remainingAmount%500;

        if(required<=atm.getNoOfFiveHundredNotes()){
            atm.deductFiveHundredNotes(required);
        }
        else if(required>atm.getNoOfFiveHundredNotes()){
            balance+=(atm.getNoOfFiveHundredNotes()*500);
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
        }

        if(balance!=0){
            super.withdraw(atm,balance);
        }
    }
}
