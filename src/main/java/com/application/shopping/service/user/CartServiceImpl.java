package com.application.shopping.service.user;

import com.application.shopping.dao.admin.ProductDao;
import com.application.shopping.dao.user.CartDao;
import com.application.shopping.dao.user.UserDao;
import com.application.shopping.entity.admin.Product;
import com.application.shopping.entity.user.Cart;
import com.application.shopping.entity.user.User;
import com.application.shopping.utils.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    ProductDao productDao;

    @Autowired
    UserDao userDao;

    @Autowired
    CartDao cartDao;

    @Autowired
    JwtUtil jwtUtil;
    @Override
    public Cart addToCart(Integer productId) {
        Product product = productDao.findById(productId).get();
        String userName = jwtUtil.CURRENT_USER;
        User user = userDao.findById(userName).get();

       List<Cart> cartItems = cartDao.findByUser(user);

       List<Cart> filteredItems = cartItems
               .stream()
               .filter(x -> Objects.equals(x.getProduct().getProductId(), productId))
               .collect(Collectors.toList());

       if(!filteredItems.isEmpty()) {
           return null;
       }

        return cartDao.save(
                Cart.builder()
                        .product(product)
                        .user(user)
                        .build()
        );

    }

    @Override
    public List<Cart> getCartDetails() {
        String userName = jwtUtil.CURRENT_USER;

        User user = userDao.findById(userName).get();

       return cartDao.findByUser(user);
    }

    @Override
    public List<Product> cartCheckout() {
       String userName =jwtUtil.CURRENT_USER;
       User user = userDao.findById(userName).get();
       List<Cart> cartDetails = cartDao.findByUser(user);

       return  cartDetails.stream().map(Cart::getProduct).collect(Collectors.toList());

    }

    @Override
    public void deleteCartItems(Integer productId) {
        cartDao.deleteById(productId);
    }


}
