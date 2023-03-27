package com.tawandev.inventoryservice.application.core.usecase;

import com.tawandev.inventoryservice.application.core.domain.Sale;
import com.tawandev.inventoryservice.application.core.domain.enums.SaleEvent;
import com.tawandev.inventoryservice.application.ports.in.CreditInventoryInputPort;
import com.tawandev.inventoryservice.application.ports.in.FindInventoryByProductIdInputPort;
import com.tawandev.inventoryservice.application.ports.out.SendToKafkaOutputPort;
import com.tawandev.inventoryservice.application.ports.out.UpdateInventoryOutputPort;

public class CreditInventoryUseCase implements CreditInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutputPort updateInventoryOutputPort;
    private final SendToKafkaOutputPort sendToKafkaOutputPort;

    public CreditInventoryUseCase(
            FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
            UpdateInventoryOutputPort updateInventoryOutputPort,
            SendToKafkaOutputPort sendToKafkaOutputPort
    ) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendToKafkaOutputPort = sendToKafkaOutputPort;
    }

    @Override
    public void credit(Sale sale) {
        var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
        inventory.creditQuantity(sale.getQuantity());
        updateInventoryOutputPort.update(inventory);
        sendToKafkaOutputPort.send(sale, SaleEvent.ROLLBACK_INVENTORY);
    }
}
