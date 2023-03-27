package com.tawandev.inventoryservice.adpters.out;

import com.tawandev.inventoryservice.adpters.out.massage.SaleMessage;
import com.tawandev.inventoryservice.application.core.domain.Sale;
import com.tawandev.inventoryservice.application.core.domain.enums.SaleEvent;
import com.tawandev.inventoryservice.application.ports.out.SendToKafkaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendToKafkaAdapter implements SendToKafkaOutputPort {

    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send("top-saga-sale", saleMessage);
    }
}
