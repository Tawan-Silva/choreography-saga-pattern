package com.tawandev.saleservice.application.ports.in;

import com.tawandev.saleservice.application.core.domain.Sale;

public interface FindSaleByIdInputPort {

    Sale find(final Integer id);
}
