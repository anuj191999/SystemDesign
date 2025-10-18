package ATMMachine.AmountWithdrawal;

import ATMMachine.ATM;

public abstract  class CashWithdrawalProcessor {
    CashWithdrawalProcessor nextCashWithdrawalProcessor;

    CashWithdrawalProcessor(CashWithdrawalProcessor cashWithdrawalProcessor){
        this.nextCashWithdrawalProcessor = cashWithdrawalProcessor;
    }

    public void withdraw(ATM atm,int remainingAmount){
        if(nextCashWithdrawalProcessor!=null){
            nextCashWithdrawalProcessor.withdraw(atm,remainingAmount);
        }
    }
}
