package com.application.shopping.service.user;

import com.application.shopping.dao.admin.ProductDao;
import com.application.shopping.dao.user.CartDao;
import com.application.shopping.dao.user.OrderDao;
import com.application.shopping.dao.user.UserDao;
import com.application.shopping.entity.user.*;
import com.application.shopping.entity.user.utils.ORDER_STATUS;
import com.application.shopping.utils.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderDao orderDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    UserDao userDao;

    @Autowired
    CartDao cartDao;

    @Autowired
    JwtUtil jwtUtil;




    @Override
    public void placeOrder(OrderDetailsInput orderDetailsInput) {
        List<ProductDetails> productDetailsList = orderDetailsInput.getProductDetailsList();
        String userName = jwtUtil.CURRENT_USER;
        User user = userDao.findById(userName).get();
        List<Cart> cartDetails = cartDao.findByUser(user);

        cartDetails.stream().forEach(x -> cartDao.deleteById(x.getCartId()));

        productDetailsList.forEach( productDetails ->
                orderDao.save(OrderDetails.builder()
                        .firstName(orderDetailsInput.getFirstName())
                        .lastName(orderDetailsInput.getLastName())
                        .email(orderDetailsInput.getEmail())
                        .orderStatus(ORDER_STATUS.PLACED.toString())
                        .phoneNumber(orderDetailsInput.getPhoneNumber())
                        .orderAmount(productDao.findById(productDetails.getProductId()).get().getProductPrice() *
                                productDetails.getProductQuantity())
                        .product(productDao.findById(productDetails.getProductId()).get())
                        .user(userDao.findById(jwtUtil.CURRENT_USER).get())
                        .build()
                )

        );

    }

    @Override
    public List<OrderDetails> getAllOrdersForUser() {
        String userName = jwtUtil.CURRENT_USER;
        User user = userDao.findById(userName).get();

        return orderDao.findByUser(user);

    }

    @Override
    public List<OrderDetails> getAllOrdersForAdmin(String status) {
        if(status.equals("All")) {
            return  (List<OrderDetails>) orderDao.findAll();
        } else {
            return orderDao.findByOrderStatus(status);
        }

    }

    @Override
    public void orderDelivered(Integer orderId) {
        OrderDetails order =orderDao.findById(orderId).get();
        order.setOrderStatus(ORDER_STATUS.DELIVERED.toString());
        orderDao.save(order);
    }
}
