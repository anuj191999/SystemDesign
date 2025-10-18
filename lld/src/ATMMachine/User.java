package ATMMachine;

public class User {
    private Card card;

    public User(){

    }
    public User(Card card) {
        this.card = card;
    }
    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }
}
