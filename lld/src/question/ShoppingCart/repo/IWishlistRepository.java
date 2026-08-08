package question.ShoppingCart.repo;

import question.ShoppingCart.models.WishList;

import java.util.Optional;

public interface IWishlistRepository {
    Optional<WishList> findByUserId(String userId);
    WishList save(WishList wishList);
}
