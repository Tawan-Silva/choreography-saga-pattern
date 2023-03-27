package com.tawandev.payment.adapters.in.consumer;

import com.tawandev.payment.adapters.out.message.SaleMessage;
import com.tawandev.payment.application.core.domain.enums.SaleEvent;
import com.tawandev.payment.application.ports.in.SalePaymentInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToPaymentConsumer {

    @Autowired
    private SalePaymentInputPort salePaymentInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "payment")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.UPDATE_INVENTORY.equals(saleMessage.getSale())) {
            log.info("Inicio do pagamento.");
            salePaymentInputPort.payment(saleMessage.getSale());
            log.info("Fim do pagamento.");
        }
    }
}
