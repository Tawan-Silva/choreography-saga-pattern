package com.tawandev.inventoryservice.application.ports.in;

import com.tawandev.inventoryservice.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {

    Inventory find(Integer productId);
}
