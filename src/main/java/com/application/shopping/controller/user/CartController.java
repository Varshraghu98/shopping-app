package com.application.shopping.controller.user;

import com.application.shopping.entity.admin.Product;
import com.application.shopping.entity.user.Cart;
import com.application.shopping.service.user.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/cart")
@PreAuthorize("hasRole('User')")
public class CartController {

    @Autowired
    CartService cartService;

    @PatchMapping({"/add/product/{productId}"})
    public Cart addToCart(@PathVariable Integer productId) {
        return cartService.addToCart(productId);

    }

    @GetMapping()
    public List<Cart> getCartDetails() {
        return cartService.getCartDetails();
    }

    @GetMapping({"/checkout"})
    public List<Product> cartCheckOut() {
        return  cartService.cartCheckout();
    }

    @DeleteMapping({"/delete/product/{productId}"})
    public void deleteCartItems(@PathVariable(name = "productId") Integer productId) {

    }


}
