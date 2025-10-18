package ATMMachine;

public class BankAccount {
    private  int balance;
    BankAccount(){
        balance = 0;
    }

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }
    public void withdraw(int amount) {
        balance -= amount;
    }

}
