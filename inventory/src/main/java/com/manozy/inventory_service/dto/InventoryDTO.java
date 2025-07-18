package com.manozy.inventory_service.dto;

import lombok.Data;

@Data
public class InventoryDTO {
    private Long id;
    private Long itemId;
    private Long productId;
    private int quantity;
}
