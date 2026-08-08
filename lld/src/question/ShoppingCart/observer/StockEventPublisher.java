package question.ShoppingCart.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Publisher (Subject) in the Observer pattern.
 * InventoryService calls publish() when stock changes.
 * CartService registers as a listener to mark items unavailable.
 */
public class StockEventPublisher {

    private static final StockEventPublisher Instance=new StockEventPublisher();
    private final List<StockEventListener> listeners=new ArrayList<>();

    private StockEventPublisher() {};
    public static StockEventPublisher getInstance(){
        return Instance;
    }

    public void subscribe(StockEventListener listener){
        listeners.add(listener);
    }
    public  void unSubscribe(StockEventListener listener){
        listeners.remove(listener);
    }

    public  void publish(String productId, int newStockQty){
        StockChangedEvent event=new StockChangedEvent(productId,newStockQty);
        for(StockEventListener listener:listeners){
            listener.onStockChanged(event);
        }
    }
}
