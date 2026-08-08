package question.ShoppingCart.models;

import question.ShoppingCart.enums.CartStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class Cart {
    private String cardId;
    private String userId; // null for guest
    private String sessionToken; // for guest carts
    private Map<String,CartItem> items; // productId <-> CartItem
    private CartStatus status;
    private Coupon appliedCoupon;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Cart(String sessionToken) {
        this.cardId= UUID.randomUUID().toString();
        this.sessionToken = sessionToken;
        this.userId=null;
        this.items=new LinkedHashMap<>();
        this.status=CartStatus.ACTIVE;
        this.createdAt=LocalDateTime.now();
        this.updatedAt=LocalDateTime.now();
    }

    public void addItem(CartItem item){
        ensureActive();
        String pid=item.getProduct().getId();
        if(items.containsKey(pid)){
            item.incrementQty();
        }
        else{
            items.put(pid,item);
        }
        touch();
    }

    public void removeItem(String productId){
        ensureActive();
        if(!items.containsKey(productId)){
            throw  new RuntimeException("Item not found in Card : "+productId);
        }
        items.remove(productId);
        touch();
    }

    public void clearCart(){
        ensureActive();
        items.clear();
        appliedCoupon=null;
        touch();
    }

    public Optional<CartItem> getItem(String productId){
        return Optional.ofNullable(items.get(productId));
    }

    public BigDecimal getSubTotal(){
        return items.values().stream()
                .map(cartItem-> cartItem.getProduct().getCost())
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    private void ensureActive(){
        if(status!=CartStatus.ACTIVE){
            throw new RuntimeException("Cart is not active. Status :"+status);
        }
    }

    private void touch(){
        this.updatedAt=LocalDateTime.now();
    }

    public Collection<CartItem> getItems(){
        return Collections.unmodifiableCollection(items.values());
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public void setItems(Map<String, CartItem> items) {
        this.items = items;
    }

    public CartStatus getStatus() {
        return status;
    }

    public void setStatus(CartStatus status) {
        this.status = status;
    }

    public Coupon getAppliedCoupon() {
        return appliedCoupon;
    }

    public void setAppliedCoupon(Coupon appliedCoupon) {
        this.appliedCoupon = appliedCoupon;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
