package observable.amazonnotifyme.observerUser;

import observable.amazonnotifyme.Observer;
public class User implements Observer {
    private int newStock;
    private String name;
    public User(String name) {
        this.newStock=0;
        this.name = name;
    }
    @Override
    public void update(int newStock) {
        this.newStock=newStock;
        display();
    }

    private void display() {
        System.out.println(this.name+": New Stock: "+newStock);
    }
}
