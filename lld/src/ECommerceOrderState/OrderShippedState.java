package ECommerceOrderState;

public class OrderShippedState implements OrderState{
    @Override
    public void next(OrderContext context) {
        System.out.println("Order has been Shipped :: Moving to Deliverable state");
        context.setOrderState(new OrderDeliveredState());
    }

    @Override
    public void cancel(OrderContext context) {
        System.out.println("Sorry We can't cancel order the order because order has been already placed");
    }
}
