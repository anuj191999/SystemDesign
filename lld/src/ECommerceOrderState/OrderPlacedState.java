package ECommerceOrderState;

public class OrderPlacedState implements OrderState{
    @Override
    public void next(OrderContext context) {
        System.out.println("Order has been placed :: Moving to the Shipped state");
        context.setOrderState(new OrderShippedState());
    }

    @Override
    public void cancel(OrderContext context) {
        System.out.println("Order has been cancelled");
        context.setOrderState(new OrderCancelledState());
    }
}
