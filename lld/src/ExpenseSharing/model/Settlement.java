package ExpenseSharing.model;

public class Settlement {

    private User payer;
    private User receiver;
    private double amount;

    public Settlement(User payer, User receiver, double amount) {
        this.payer = payer;
        this.receiver = receiver;
        this.amount = amount;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Settlement{" +
                "payer=" + payer.getName() +
                ", receiver=" + receiver.getName() +
                ", amount=" + amount +
                '}';
    }
}
