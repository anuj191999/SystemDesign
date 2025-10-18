package ATMMachine.ATMStates;

import ATMMachine.ATM;
import ATMMachine.AmountWithdrawal.CashWithdrawalProcessor;
import ATMMachine.AmountWithdrawal.FiveHundredWithdrawProcessor;
import ATMMachine.AmountWithdrawal.OneHundredWithdrawProcessor;
import ATMMachine.AmountWithdrawal.TwoThousandWithdrawProcessor;
import ATMMachine.Card;

public class CashWithdrawalState extends ATMState {

    public CashWithdrawalState() {
        System.out.println("Please enter the amount to withdraw");
    }

    @Override
    public void cashWithdrawal(ATM atmObject, Card card,int withdrawalAmount) {

        if(atmObject.getAtmBalance()<withdrawalAmount) {
            System.out.println("Insufficient funds in the ATM machine");
            exit(atmObject);
        }
        else if(card.getBankBalance()<withdrawalAmount) {
            System.out.println("Insufficient funds in your Bank account");
            exit(atmObject);
        }
        else{
            card.deductBalance(withdrawalAmount);
            atmObject.deductATMBalance(withdrawalAmount);

            /**
             * using Chain of Responsibility for this logic
             * how many 2k rs notes , how many 500 rs notes etc, has to be withdrawal.
             */

            CashWithdrawalProcessor withdrawalProcessor=new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));

            withdrawalProcessor.withdraw(atmObject,withdrawalAmount);
            exit(atmObject);
        }
    }
    @Override
    public void exit(ATM atmObject) {
        returnCard();
        atmObject.setCurrentATMState(null);
        System.out.println("Exit Happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please Collect your Card");
    }


}
