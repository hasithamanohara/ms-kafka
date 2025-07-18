package com.manozy.inventory_service.repo;

import com.manozy.inventory_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory, Long> {
    Inventory findByItemId(Long itemId);
}
