package question.ShoppingCart.repo.impl;

import question.ShoppingCart.models.Cart;
import question.ShoppingCart.repo.ICartRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryCartRepository implements ICartRepository {

    private final Map<String,Cart> byId=new HashMap<>();
    private final Map<String,String> userIndex=new HashMap<>(); // userId <-> cartId
    private final Map<String,String> sessIndex=new HashMap<>(); // sessionToken <-> cartId

    @Override
    public Optional<Cart> findByUserId(String userId) {
        return Optional.ofNullable(userIndex.get(userId)).map(byId::get);
    }

    @Override
    public Optional<Cart> findBySessionToken(String token) {
        return Optional.ofNullable(sessIndex.get(token)).map(byId::get);
    }

    @Override
    public Cart save(Cart cart) {
        byId.put(cart.getUserId(),cart);
        if(cart.getUserId()!=null){
            userIndex.put(cart.getUserId(),cart.getCardId());
        }
        if (cart.getSessionToken()!=null){
            sessIndex.put(cart.getSessionToken(), cart.getCardId());
        }
        return cart;
    }

    @Override
    public void delete(String cardId) {
        Cart cart=byId.remove(cardId);
        if(cart!=null){
            if(cart.getUserId()!=null){
                userIndex.remove(cart.getUserId());
            }
            if(cart.getSessionToken()!=null){
                sessIndex.remove(cart.getSessionToken());
            }
        }
    }
}
