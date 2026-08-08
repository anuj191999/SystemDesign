package question.ShoppingCart.repo.impl;

import question.ShoppingCart.models.WishList;
import question.ShoppingCart.repo.IWishlistRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryWishlistRepository implements IWishlistRepository {

    private final Map<String,WishList> store=new HashMap<>();

    @Override
    public Optional<WishList> findByUserId(String userId) {
        return Optional.ofNullable(store.get(userId));
    }

    @Override
    public WishList save(WishList wishList) {
        store.put(wishList.getUserId(),wishList);

        return wishList;
    }
}
