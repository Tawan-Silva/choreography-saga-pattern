package com.tawandev.saleservice.application.ports.out;

import com.tawandev.saleservice.application.core.domain.Sale;
import com.tawandev.saleservice.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutputPort {

    void send(Sale sale, SaleEvent event);
}
