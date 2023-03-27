package com.tawandev.payment.config.usecase;

import com.tawandev.payment.adapters.out.SavePaymentAdapter;
import com.tawandev.payment.adapters.out.SendToKafkaAdapter;
import com.tawandev.payment.adapters.out.UpdateUserAdapter;
import com.tawandev.payment.application.core.usecase.FindUserByIdUseCase;
import com.tawandev.payment.application.core.usecase.SalePaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalePaymentConfig {

    @Bean
    public SalePaymentUseCase salePaymentUseCase(
            FindUserByIdUseCase findUserByIdUseCase,
            UpdateUserAdapter updateUserAdapter,
            SavePaymentAdapter savePaymentAdapter,
            SendToKafkaAdapter sendToKafkaAdapter
    ) {
        return new SalePaymentUseCase(
                findUserByIdUseCase,
                updateUserAdapter,
                savePaymentAdapter,
                sendToKafkaAdapter
        );
    }
}
