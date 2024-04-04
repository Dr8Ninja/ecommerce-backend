package com.ecom.Service;

import com.ecom.Model.Orders;
import com.ecom.Model.User;

import java.util.List;

public interface OrderService {
    List<Orders> getOrders(User user);
}
