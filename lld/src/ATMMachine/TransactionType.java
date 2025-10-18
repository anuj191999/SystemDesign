package ATMMachine;

public enum TransactionType {
    CASH_WITHDRAWAL,
    BALANCE_CHECK;

    public static void showAllTransactionTypes() {
        for (TransactionType transactionType : TransactionType.values()) {
            System.out.println(transactionType.toString());
        }
    }
}
