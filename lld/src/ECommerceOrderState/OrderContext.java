package ECommerceOrderState;

public class OrderContext {
    private OrderState currentState;
    public OrderContext() {
        this.currentState = new OrderPlacedState();
    }
    public void setOrderState(OrderState orderState) {
        this.currentState = orderState;
    }
    public void proceedToNext(){
        currentState.next(this);
    }
    public void cancelOrder(){
        currentState.cancel(this);
    }
}
