package ATMMachine.AmountWithdrawal;

import ATMMachine.ATM;

public class TwoThousandWithdrawProcessor extends CashWithdrawalProcessor{

    public TwoThousandWithdrawProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor) {
        super(nextCashWithdrawalProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount){
        int required=remainingAmount/2000;
        int balance=remainingAmount%2000;

        if(required<=atm.getNoOfTwoThousandNotes()){
            atm.deductTwoThousandNotes(required);
        }
        else if(required>atm.getNoOfTwoThousandNotes()){
            balance+=(atm.getNoOfTwoThousandNotes()*2000);
            atm.deductTwoThousandNotes(atm.getNoOfFiveHundredNotes());
        }

        if(balance!=0){
            super.withdraw(atm,balance);
        }
    }
}
