package question.ShoppingCart.models;

import question.ShoppingCart.enums.UserType;

import java.util.UUID;

public class User {

    private String userId;
    private String name;
    private String cartId;
    private String wishlistId;
    private UserType userType;

    /**
     *
     * Some additional Field that will be based on business requirement
     */

    public User(String name) {
        this.name = name;
        this.userId= UUID.randomUUID().toString();
    }

    public String getUserId() {
        return userId;
    }

    public String getCartId() {
        return cartId;
    }

    public String getWishlistId() {
        return wishlistId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public void setWishlistId(String wishlistId) {
        this.wishlistId = wishlistId;
    }
    public boolean isGuest(){
        return userType==UserType.GUEST;
    }
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
