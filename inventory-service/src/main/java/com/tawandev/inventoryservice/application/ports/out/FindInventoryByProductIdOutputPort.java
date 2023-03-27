package com.tawandev.inventoryservice.application.ports.out;

import com.tawandev.inventoryservice.application.core.domain.Inventory;

import java.util.Optional;

public interface FindInventoryByProductIdOutputPort {

    Optional<Inventory> find(final Integer productId);
}
