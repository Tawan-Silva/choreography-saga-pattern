package com.tawandev.payment.adapters.out.message;

import com.tawandev.payment.application.core.domain.Sale;
import com.tawandev.payment.application.core.domain.enums.SaleEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleMessage {

    private Sale sale;

    private SaleEvent event;
}
