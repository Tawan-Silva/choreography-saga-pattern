package com.tawandev.saleservice.application.ports.out;

import com.tawandev.saleservice.application.core.domain.Sale;

public interface SaveSaleOutputPort {

    Sale save(Sale sale);
}
