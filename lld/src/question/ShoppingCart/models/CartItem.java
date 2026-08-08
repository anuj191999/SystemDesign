package question.ShoppingCart.models;

public class CartItem {
    private String cartItemId;
    private Product product;
    private int quantity;

    public CartItem(String cartItemId, Product product) {
        this.cartItemId = cartItemId;
        this.product = product;
        this.quantity = 1;
    }

    public String getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incrementQty(){

    }

    public void decrementQty(){

    }

    public void setQty(){

    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId='" + cartItemId + '\'' +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
