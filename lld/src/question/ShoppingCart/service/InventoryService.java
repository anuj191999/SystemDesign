package question.ShoppingCart.service;

import question.ShoppingCart.observer.StockEventPublisher;
import question.ShoppingCart.repo.IInventoryRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class InventoryService {

    private final IInventoryRepository inventoryRepo;
    private final StockEventPublisher eventPublisher;

    private final Set<String> lockedProducts= Collections.synchronizedSet(new HashSet<>());
    public  InventoryService(IInventoryRepository inventoryRepo){
        this.inventoryRepo=inventoryRepo;
        this.eventPublisher=StockEventPublisher.getInstance();
    }

//    public boolean checkAvailability(String productId, int requestQty){
//    }
}
