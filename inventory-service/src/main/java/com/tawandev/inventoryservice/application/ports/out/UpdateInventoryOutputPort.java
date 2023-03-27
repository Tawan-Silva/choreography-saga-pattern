package com.tawandev.inventoryservice.application.ports.out;

import com.tawandev.inventoryservice.application.core.domain.Inventory;

public interface UpdateInventoryOutputPort {

    void update(Inventory inventory);
}
