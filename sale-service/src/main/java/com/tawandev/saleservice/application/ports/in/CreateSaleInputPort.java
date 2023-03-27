package com.tawandev.saleservice.application.ports.in;

import com.tawandev.saleservice.application.core.domain.Sale;

public interface CreateSaleInputPort {

    void create(Sale sale);
}
