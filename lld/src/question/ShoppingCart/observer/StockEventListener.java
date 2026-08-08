package question.ShoppingCart.observer;

public interface StockEventListener {
   void onStockChanged(StockChangedEvent event);
}
