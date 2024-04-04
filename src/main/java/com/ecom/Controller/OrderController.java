package com.ecom.Controller;

import com.ecom.Model.Orders;
import com.ecom.Model.User;
import com.ecom.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public List<Orders> getOrders(@AuthenticationPrincipal User user){
        return orderService.getOrders(user);
    }
}
