package com.tawandev.saleservice.application.core.usecase;

import com.tawandev.saleservice.application.core.domain.Sale;
import com.tawandev.saleservice.application.ports.in.FindSaleByIdInputPort;
import com.tawandev.saleservice.application.ports.out.FindSaleByIdOutputPort;

public class FindSaleByIdUseCase implements FindSaleByIdInputPort {

    private final FindSaleByIdOutputPort findSaleByIdOutputPort;

    public FindSaleByIdUseCase(FindSaleByIdOutputPort findSaleByIdOutputPort) {
        this.findSaleByIdOutputPort = findSaleByIdOutputPort;
    }

    @Override
    public Sale find(final Integer id) {
        return findSaleByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada!"));
    }
}
