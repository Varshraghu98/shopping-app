package com.application.shopping.controller.admin;

import com.application.shopping.entity.user.OrderDetails;
import com.application.shopping.service.user.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/orders")
@PreAuthorize("hasRole('Admin')")
public class AdminOrderController {

    @Autowired
    OrderService orderService;

    @GetMapping()
    public List<OrderDetails> getAllOrders(@RequestParam(name = "status", defaultValue="All") String status) {
        return orderService.getAllOrdersForAdmin(status);
    }

    @PutMapping(value = {"/delivered"})
    public  void markOrderDelivered(@RequestParam(name = "orderId") Integer orderId) {
        orderService.orderDelivered(orderId);

    }

}
