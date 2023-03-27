package com.tawandev.payment.adapters.out.repository.mapper;

import com.tawandev.payment.adapters.out.repository.entity.PaymentEntity;
import com.tawandev.payment.application.core.domain.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {

    PaymentEntity toPaymentEntity(Payment payment);
}
