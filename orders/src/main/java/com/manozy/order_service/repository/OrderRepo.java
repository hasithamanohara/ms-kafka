package com.manozy.order_service.repository;

import com.manozy.order_service.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders, Long> {
//    Order getOrderById(Long id);
}
