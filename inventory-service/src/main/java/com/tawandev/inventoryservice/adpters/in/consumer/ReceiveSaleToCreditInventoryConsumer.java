package com.tawandev.inventoryservice.adpters.in.consumer;

import com.tawandev.inventoryservice.adpters.out.massage.SaleMessage;
import com.tawandev.inventoryservice.application.core.domain.enums.SaleEvent;
import com.tawandev.inventoryservice.application.ports.in.CreditInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToCreditInventoryConsumer {

    @Autowired
    private CreditInventoryInputPort creditInventoryInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "inventory-credit")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.FAILED_PAYMENT.equals(saleMessage.getEvent())) {
            log.info("Início da devolução da mercadoria.");
            creditInventoryInputPort.credit(saleMessage.getSale());
            log.info("Fim da devolução da mercadoria.");
        }
    }
}
