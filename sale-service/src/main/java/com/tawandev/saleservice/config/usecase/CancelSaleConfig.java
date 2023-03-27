package com.tawandev.saleservice.config.usecase;

import com.tawandev.saleservice.adapters.out.SaveSaleAdapter;
import com.tawandev.saleservice.application.core.usecase.CancelSaleUseCase;
import com.tawandev.saleservice.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CancelSaleConfig {

    @Bean
    public CancelSaleUseCase cancelSaleUseCase(
        FindSaleByIdUseCase findSaleByIdUseCase,
        SaveSaleAdapter saveSaleAdapter
    ) {
        return new CancelSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }
}
