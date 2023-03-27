package com.tawandev.payment.application.ports.out;

import com.tawandev.payment.application.core.domain.Sale;
import com.tawandev.payment.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {

    void send(Sale sale, SaleEvent event);
}
