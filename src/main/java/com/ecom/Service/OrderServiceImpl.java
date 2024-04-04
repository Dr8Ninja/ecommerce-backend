package com.ecom.Service;

import com.ecom.Model.Orders;
import com.ecom.Model.User;
import com.ecom.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    public List<Orders> getOrders(User user){
        return orderRepository.findByUser(user);
    }
}
