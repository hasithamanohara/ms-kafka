package com.manozy.inventory_service.service;

import com.manozy.inventory_service.dto.InventoryDTO;
import com.manozy.inventory_service.model.Inventory;
import com.manozy.inventory_service.repo.InventoryRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepo inventoryRepo;
    private final ModelMapper modelMapper;

    public List<InventoryDTO> getAllItems() {
        List<Inventory>itemList = inventoryRepo.findAll();
        return modelMapper.map(itemList, new TypeToken<List<InventoryDTO>>(){}.getType());
    }

    public InventoryDTO saveItem(InventoryDTO inventoryDTO) {
        inventoryRepo.save(modelMapper.map(inventoryDTO, Inventory.class));
        return inventoryDTO;
    }

    public InventoryDTO updateItem(InventoryDTO inventoryDTO) {
        inventoryRepo.save(modelMapper.map(inventoryDTO, Inventory.class));
        return inventoryDTO;
    }

    public String deleteItem(Long itemId) {
        inventoryRepo.deleteById(itemId);
        return "Item deleted";
    }

    public InventoryDTO getItemById(Long itemId) {
        Inventory item = inventoryRepo.findByItemId(itemId);
        return modelMapper.map(item, InventoryDTO.class);
    }
}
