# Shopping Cart

---

## Functional Requirement

### 1. Cart Management

- Each user has only one active cart
- Add/Remove Item to cart
- Clear entire Item to card
- Increment/Decrement quantity to card
- Max quantity limit per cart

### 2. Wishlist/ save for later

- Move item from cart to wishlist
- move item back to cart

### 3. Pricing

- Calculate total cart amount
- Apply discounts/coupons
- Calculate taxes and shopping charges+Platform charges
- Validate latest product price before checkout

### 4. Inventory Management

- Validate product availability during checkout
- Handle out of stock items gracefully
- Handle Concurrent Inventory Updates

### 5. User & Session Handling

- Support guest users
- persist cart across session for logged - in user
- merge guest cart after login

### 6. Checkout 

- Provide Order Summary before payment
- Clear cart after successful checkout 
