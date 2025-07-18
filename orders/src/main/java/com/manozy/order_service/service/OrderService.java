package com.manozy.order_service.service;

import com.manozy.order_service.dto.OrderDto;
import com.manozy.order_service.model.Orders;
import com.manozy.order_service.repository.OrderRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final ModelMapper modelMapper;
    private final OrderRepo orderRepo;

    public OrderDto createOrder(OrderDto orderDto) {
        Orders orders = modelMapper.map(orderDto, Orders.class);
        orderRepo.save(orders);
        return modelMapper.map(orders, OrderDto.class);
    }

    public List<OrderDto> getAllOrders() {
        List<Orders> ordersList = orderRepo.findAll();
        return modelMapper.map(ordersList, new TypeToken<List<OrderDto>>() {
        }.getType());
    }

    public OrderDto updateOrder(OrderDto orderDto) {
        orderRepo.save(modelMapper.map(orderDto, Orders.class));
        return orderDto;
    }

    public String deleteOrder(Long orderId) {
        orderRepo.deleteById(orderId);
        return "Order deleted";
    }

    public OrderDto getOrderById(Long orderId) {
        Orders orders = orderRepo.findById(orderId).orElse(null);
        return modelMapper.map(orders, OrderDto.class);
    }
}
