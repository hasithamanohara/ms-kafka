package com.manozy.inventory_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Inventory {
    @Id
    private Long id;
    private Long itemId;
    private Long productId;
    private int quantity;
}
