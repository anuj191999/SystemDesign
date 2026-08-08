package question.ShoppingCart.observer;

public class StockChangedEvent {
    private final String productId;
    private final int newStockQty;
    private final boolean outOfStock;

    public StockChangedEvent(String productId, int newStockQty) {
        this.productId = productId;
        this.newStockQty = newStockQty;
        this.outOfStock = newStockQty==0;
    }

    public String getProductId() {
        return productId;
    }

    public int getNewStockQty() {
        return newStockQty;
    }

    public boolean isOutOfStock() {
        return outOfStock;
    }
}
