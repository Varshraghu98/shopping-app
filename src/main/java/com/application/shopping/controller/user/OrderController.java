package com.application.shopping.controller.user;

import com.application.shopping.entity.user.OrderDetails;
import com.application.shopping.entity.user.OrderDetailsInput;
import com.application.shopping.service.user.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/order")
@PreAuthorize("hasRole('User')")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public void placeOrder(@RequestBody OrderDetailsInput orderDetailsInput) {
        orderService.placeOrder(orderDetailsInput);
    }

    @GetMapping("/getAll")
    public List<OrderDetails> getAllOrders(){
        return orderService.getAllOrdersForUser();
    }

}
