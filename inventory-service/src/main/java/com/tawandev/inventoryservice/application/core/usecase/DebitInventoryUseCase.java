package com.tawandev.inventoryservice.application.core.usecase;

import com.tawandev.inventoryservice.application.core.domain.Sale;
import com.tawandev.inventoryservice.application.core.domain.enums.SaleEvent;
import com.tawandev.inventoryservice.application.ports.in.DebitInventoryInputPort;
import com.tawandev.inventoryservice.application.ports.in.FindInventoryByProductIdInputPort;
import com.tawandev.inventoryservice.application.ports.out.SendToKafkaOutputPort;
import com.tawandev.inventoryservice.application.ports.out.UpdateInventoryOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DebitInventoryUseCase implements DebitInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutputPort updateInventoryOutputPort;

    private final SendToKafkaOutputPort sendToKafkaOutputPort;

    public DebitInventoryUseCase(
            FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
            UpdateInventoryOutputPort updateInventoryOutputPort,
            SendToKafkaOutputPort sendToKafkaOutputPort
    ) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendToKafkaOutputPort = sendToKafkaOutputPort;
    }

    @Override
    public void debit(Sale sale) {
        try {
            var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
            if (inventory.getQuantity() < sale.getQuantity()) {
                throw new RuntimeException("Estoque insuficiente.");
            }
            inventory.debitQuantity(sale.getQuantity());
            updateInventoryOutputPort.update(inventory);
            sendToKafkaOutputPort.send(sale, SaleEvent.UPDATE_INVENTORY);
        } catch (Exception e) {
            log.error("Houve um erro = {}", e.getMessage());
            sendToKafkaOutputPort.send(sale, SaleEvent.ROLLBACK_INVENTORY);
        }

    }
}
