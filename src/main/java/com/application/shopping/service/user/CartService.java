package com.application.shopping.service.user;

import com.application.shopping.entity.admin.Product;
import com.application.shopping.entity.user.Cart;

import java.util.List;

public interface CartService {

    Cart addToCart(Integer productId);

    List<Cart> getCartDetails();

    List<Product> cartCheckout();

    void deleteCartItems(Integer productId);
}
