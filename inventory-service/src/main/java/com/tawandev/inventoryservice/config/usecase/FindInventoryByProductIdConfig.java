package com.tawandev.inventoryservice.config.usecase;

import com.tawandev.inventoryservice.adpters.out.FindInventoryByProductIdAdapter;
import com.tawandev.inventoryservice.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindInventoryByProductIdConfig {

    @Bean
    public FindInventoryByProductIdUseCase findInventoryByProductIdUseCase(
            FindInventoryByProductIdAdapter findInventoryByProductIdAdapter
    ) {
        return new FindInventoryByProductIdUseCase(findInventoryByProductIdAdapter);
    }
}
