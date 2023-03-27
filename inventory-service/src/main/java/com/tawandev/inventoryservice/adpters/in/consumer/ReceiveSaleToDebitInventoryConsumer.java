package com.tawandev.inventoryservice.adpters.in.consumer;

import com.tawandev.inventoryservice.adpters.out.massage.SaleMessage;
import com.tawandev.inventoryservice.application.core.domain.enums.SaleEvent;
import com.tawandev.inventoryservice.application.ports.in.DebitInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToDebitInventoryConsumer {

    @Autowired
    private DebitInventoryInputPort debitInventoryInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "inventory-debit")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.CREATE_SALE.equals(saleMessage.getEvent())) {
            log.info("Inicio da separação de mercadoria.");
            debitInventoryInputPort.debit(saleMessage.getSale());
            log.info("Fim de separação de mercadoria.");
        }
    }
}
