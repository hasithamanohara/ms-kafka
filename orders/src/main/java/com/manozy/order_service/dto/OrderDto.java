package com.manozy.order_service.dto;

import lombok.Data;

@Data
public class OrderDto {
    private Long id;
    private Long itemId;
    private String orderDate;
    private double amount;
}
