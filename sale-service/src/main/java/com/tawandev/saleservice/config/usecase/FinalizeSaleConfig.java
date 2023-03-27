package com.tawandev.saleservice.config.usecase;

import com.tawandev.saleservice.adapters.out.SaveSaleAdapter;
import com.tawandev.saleservice.application.core.usecase.FinalizeSaleUseCase;
import com.tawandev.saleservice.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinalizeSaleConfig {

    @Bean
    public FinalizeSaleUseCase finalizeSaleUseCase(
            FindSaleByIdUseCase findSaleByIdUseCase,
            SaveSaleAdapter saveSaleAdapter
    ) {
        return new FinalizeSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }
}
