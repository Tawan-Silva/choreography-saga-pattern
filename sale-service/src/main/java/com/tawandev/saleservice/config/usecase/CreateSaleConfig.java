package com.tawandev.saleservice.config.usecase;

import com.tawandev.saleservice.adapters.out.SaveSaleAdapter;
import com.tawandev.saleservice.adapters.out.SendCreatedSaleAdapter;
import com.tawandev.saleservice.application.core.usecase.CreateSaleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateSaleConfig {

    @Bean
    public CreateSaleUseCase createSaleUseCase(
        SaveSaleAdapter saveSaleAdapter,
        SendCreatedSaleAdapter sendCreatedSaleAdapter
    ) {
        return new CreateSaleUseCase(saveSaleAdapter, sendCreatedSaleAdapter);
    }
}
