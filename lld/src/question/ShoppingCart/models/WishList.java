package question.ShoppingCart.models;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class WishList {

    private final String wishlistId;
    private final String userId;
    private final Map<String,WishlistItem> items;

    public WishList(String userId) {
        this.userId = userId;
        this.wishlistId= UUID.randomUUID().toString();
        this.items=new LinkedHashMap<>();
    }

    public void addItem(WishlistItem item){
        items.putIfAbsent(item.getProductId(),item);
    }

    public Optional<WishlistItem> removeItem(String productId){
        return Optional.ofNullable(items.remove(productId));
    }

    public String getWishlistId() {
        return wishlistId;
    }

    public String getUserId() {
        return userId;
    }

    public Map<String, WishlistItem> getItems() {
        return items;
    }
}
