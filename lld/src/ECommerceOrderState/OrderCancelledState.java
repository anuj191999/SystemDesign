package ECommerceOrderState;

public class OrderCancelledState implements OrderState{
    @Override
    public void next(OrderContext context) {
        System.out.println("Cannot proceed. Order is cancelled.");
    }

    @Override
    public void cancel(OrderContext context) {
        System.out.println("Order is already cancelled.");
    }
}
