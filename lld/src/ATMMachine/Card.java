package ATMMachine;

public class Card {

    private int cardNumber;
    private int cvv;
    private int expiryYear;
    private String cardHolderName;
    static int PIN_NUMBER=1122;
    private BankAccount bankAccount;

    public Card(){

    }
    public Card(int cardNumber, int cvv, int expiryYear) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryYear = expiryYear;
    }

    public boolean isCorrectPINEntered(int pin){
        return (pin == PIN_NUMBER);
    }
    public int getBankBalance() {
        return bankAccount.getBalance();
    }
    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    public void deductBalance(int amount) {
        bankAccount.withdraw(amount);
    }
}
