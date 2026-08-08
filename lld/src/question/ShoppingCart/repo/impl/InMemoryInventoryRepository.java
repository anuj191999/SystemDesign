package question.ShoppingCart.repo.impl;

import question.ShoppingCart.models.Product;
import question.ShoppingCart.repo.IInventoryRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryInventoryRepository  implements IInventoryRepository {
    private final Map<String, Long> idByQty;  // productId <-> qty
    private final Map<String, Product> idByProduct; // productId <-> productInstance
    private final Map<String,Long> idByQtyReserved; // productId <-> their Reserved Qty;

    public InMemoryInventoryRepository() {
        this.idByQty = new HashMap<>();
        this.idByProduct = new HashMap<>();
        this.idByQtyReserved = new HashMap<>();
    }

    @Override
    public void updateInventoryStockOfProduct(Product product, Long qty) {
        idByQty.put(product.getId(),idByQty.getOrDefault(product.getId(),0L)+qty);
        idByProduct.computeIfAbsent(product.getId(), id->product);
    }

    @Override
    public void updateInventoryReservedStockOfProduct(Product product, Long qty) {
        if(idByQty.getOrDefault(product.getId(),0L)>qty){
            idByQtyReserved.put(product.getId(), idByQtyReserved.getOrDefault(product.getId(),0L)-qty);
        }
    }

    @Override
    public long getProductStock(String productId) {
        return 0;
    }

    @Override
    public long getReservedStock(String productId) {
        return 0;
    }
}
