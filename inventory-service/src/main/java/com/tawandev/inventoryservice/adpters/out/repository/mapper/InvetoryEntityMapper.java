package com.tawandev.inventoryservice.adpters.out.repository.mapper;

import com.tawandev.inventoryservice.adpters.out.repository.entity.InventoryEntity;
import com.tawandev.inventoryservice.application.core.domain.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvetoryEntityMapper {

    Inventory toInventory(InventoryEntity inventory);

    InventoryEntity toInventoryEntity(Inventory inventory);
}
