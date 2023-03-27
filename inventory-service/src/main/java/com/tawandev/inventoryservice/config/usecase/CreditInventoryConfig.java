package com.tawandev.inventoryservice.config.usecase;

import com.tawandev.inventoryservice.adpters.out.UpdateInventoryAdapter;
import com.tawandev.inventoryservice.application.core.usecase.CreditInventoryUseCase;
import com.tawandev.inventoryservice.application.core.usecase.FindInventoryByProductIdUseCase;
import com.tawandev.inventoryservice.application.ports.out.SendToKafkaOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditInventoryConfig {

    @Bean
    public CreditInventoryUseCase creditInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter,
            SendToKafkaOutputPort sendToKafkaOutputPort
    ) {
       return new CreditInventoryUseCase(
               findInventoryByProductIdUseCase,
               updateInventoryAdapter,
               sendToKafkaOutputPort
       );
    }
}
