package com.tawandev.saleservice.config.usecase;

import com.tawandev.saleservice.adapters.out.FindSaleByIdAdapter;
import com.tawandev.saleservice.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindSaleByIdConfig {

    @Bean
    public FindSaleByIdUseCase findSaleByIdUseCase(
            FindSaleByIdAdapter findSaleByIdAdapter
    ) {
        return new FindSaleByIdUseCase(findSaleByIdAdapter);
    }
}
