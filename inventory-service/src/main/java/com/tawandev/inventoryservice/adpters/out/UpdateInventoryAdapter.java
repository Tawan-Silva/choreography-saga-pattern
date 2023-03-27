package com.tawandev.inventoryservice.adpters.out;

import com.tawandev.inventoryservice.adpters.out.repository.InventoryRepository;
import com.tawandev.inventoryservice.adpters.out.repository.mapper.InvetoryEntityMapper;
import com.tawandev.inventoryservice.application.core.domain.Inventory;
import com.tawandev.inventoryservice.application.ports.out.UpdateInventoryOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateInventoryAdapter implements UpdateInventoryOutputPort {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InvetoryEntityMapper invetoryEntityMapper;

    @Override
    public void update(Inventory inventory) {
        var inventoryEntity = invetoryEntityMapper.toInventoryEntity(inventory);
        inventoryRepository.save(inventoryEntity);
    }
}
