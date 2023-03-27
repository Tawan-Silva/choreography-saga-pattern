package com.tawandev.inventoryservice.application.core.usecase;

import com.tawandev.inventoryservice.application.core.domain.Inventory;
import com.tawandev.inventoryservice.application.ports.in.FindInventoryByProductIdInputPort;
import com.tawandev.inventoryservice.application.ports.out.FindInventoryByProductIdOutputPort;

public class FindInventoryByProductIdUseCase implements FindInventoryByProductIdInputPort {

    private FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort;

    public FindInventoryByProductIdUseCase(FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort) {
        this.findInventoryByProductIdOutputPort = findInventoryByProductIdOutputPort;
    }

    @Override
    public Inventory find(Integer productId) {
        return findInventoryByProductIdOutputPort.find(productId)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado para este produto!"));
    }
}
