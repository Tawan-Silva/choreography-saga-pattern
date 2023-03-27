package com.tawandev.inventoryservice.adpters.out;

import com.tawandev.inventoryservice.adpters.out.repository.InventoryRepository;
import com.tawandev.inventoryservice.adpters.out.repository.mapper.InvetoryEntityMapper;
import com.tawandev.inventoryservice.application.core.domain.Inventory;
import com.tawandev.inventoryservice.application.ports.out.FindInventoryByProductIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindInventoryByProductIdAdapter implements FindInventoryByProductIdOutputPort {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InvetoryEntityMapper invetoryEntityMapper;
    @Override
    public Optional<Inventory> find(Integer productId) {
        var inventoryEntity = inventoryRepository.findByProductId(productId);
        return inventoryEntity.map(invetoryEntityMapper::toInventory);
    }
}
