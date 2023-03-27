package com.tawandev.saleservice.application.ports.out;

import com.tawandev.saleservice.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdOutputPort {

    Optional<Sale> find(final Integer id);
}
