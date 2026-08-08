package question.ShoppingCart.models;

public class WishlistItem {

    private final String productId;
    private final String productName;

    public WishlistItem(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }
}
