package com.tawandev.inventoryservice.config.usecase;

import com.tawandev.inventoryservice.application.core.usecase.DebitInventoryUseCase;
import com.tawandev.inventoryservice.application.core.usecase.FindInventoryByProductIdUseCase;
import com.tawandev.inventoryservice.application.ports.out.SendToKafkaOutputPort;
import com.tawandev.inventoryservice.application.ports.out.UpdateInventoryOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebitInventoryConfig {

    @Bean
    public DebitInventoryUseCase debitInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryOutputPort updateInventoryOutputPort,
            SendToKafkaOutputPort sendToKafkaOutputPort
    ) {
        return new DebitInventoryUseCase(
                findInventoryByProductIdUseCase,
                updateInventoryOutputPort,
                sendToKafkaOutputPort
        );
    }
}
