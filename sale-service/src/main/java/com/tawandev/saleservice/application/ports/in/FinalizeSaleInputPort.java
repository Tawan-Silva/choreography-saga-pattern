package com.tawandev.saleservice.application.ports.in;

import com.tawandev.saleservice.application.core.domain.Sale;

public interface FinalizeSaleInputPort {

    void finalize(Sale sale);
}
