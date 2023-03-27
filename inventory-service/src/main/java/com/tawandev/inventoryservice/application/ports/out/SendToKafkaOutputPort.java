package com.tawandev.inventoryservice.application.ports.out;

import com.tawandev.inventoryservice.application.core.domain.Sale;
import com.tawandev.inventoryservice.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {

    void send(Sale sale, SaleEvent event);
}
