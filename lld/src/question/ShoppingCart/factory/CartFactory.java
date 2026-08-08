package question.ShoppingCart.factory;

import question.ShoppingCart.models.Cart;
import question.ShoppingCart.models.User;

import java.util.UUID;

/**
 * Factory Pattern — centralises Cart creation logic.
 * Guest carts carry a sessionToken; registered carts carry a userId.
 */
public class CartFactory {
    private CartFactory(){}

    public  static Cart create(User user){
        if(user.isGuest()){
            String sessionToken="GUEST- "+ UUID.randomUUID().toString();
            return new Cart(sessionToken);
        }
        return new Cart(user.getUserId());
    }

    public static Cart createGuestCart(String sessionToken){
        return new Cart(sessionToken);
    }

    public  static Cart createForUser(String userId){
        return new Cart(userId);
    }

}
