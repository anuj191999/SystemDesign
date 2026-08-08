package question.ShoppingCart.repo;


import question.ShoppingCart.models.Product;

public interface IInventoryRepository {

    void updateInventoryStockOfProduct(Product product,Long qty);
    void updateInventoryReservedStockOfProduct(Product product,Long qty);
    long getProductStock(String productId);
    long getReservedStock(String productId);
}
