package com.ecom.Repository;

import com.ecom.Model.Orders;
import com.ecom.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Long> {
    List<Orders> findByUser(User user);
}
