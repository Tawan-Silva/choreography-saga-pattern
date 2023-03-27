package com.tawandev.saleservice.adapters.out;

import com.tawandev.saleservice.adapters.out.message.SaleMessage;
import com.tawandev.saleservice.application.core.domain.Sale;
import com.tawandev.saleservice.application.core.domain.enums.SaleEvent;
import com.tawandev.saleservice.application.ports.out.SendCreatedSaleOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCreatedSaleAdapter implements SendCreatedSaleOutputPort {

    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send("tp-saga-sale", saleMessage);
    }
}
