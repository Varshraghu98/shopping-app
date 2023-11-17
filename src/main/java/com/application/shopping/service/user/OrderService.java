package com.application.shopping.service.user;

import com.application.shopping.entity.user.OrderDetails;
import com.application.shopping.entity.user.OrderDetailsInput;

import java.util.List;

public interface OrderService {

        void placeOrder(OrderDetailsInput orderDetailsInput);

        List<OrderDetails> getAllOrdersForUser();

        List<OrderDetails> getAllOrdersForAdmin(String status);

        void orderDelivered(Integer orderId);


}
