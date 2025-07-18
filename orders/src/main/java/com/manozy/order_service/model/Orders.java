package com.manozy.order_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Orders {
    @Id
    private Long id;
    private Long itemId;
    private String orderDate;
    private double amount;
}
