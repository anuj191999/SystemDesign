package ECommerceOrderState;

public class OrderDeliveredState implements OrderState{

    @Override
    public void next(OrderContext context) {
        System.out.println("Wow :: Order Delivered Thanks for service");
    }

    @Override
    public void cancel(OrderContext context) {

        System.out.println("Cannot cancel. Order is already delivered.");
    }
}
