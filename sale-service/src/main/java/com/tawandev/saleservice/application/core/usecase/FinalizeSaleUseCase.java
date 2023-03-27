package com.tawandev.saleservice.application.core.usecase;

import com.tawandev.saleservice.application.core.domain.Sale;
import com.tawandev.saleservice.application.core.domain.enums.SaleStatus;
import com.tawandev.saleservice.application.ports.in.FinalizeSaleInputPort;
import com.tawandev.saleservice.application.ports.in.FindSaleByIdInputPort;
import com.tawandev.saleservice.application.ports.out.SaveSaleOutputPort;

public class FinalizeSaleUseCase implements FinalizeSaleInputPort {

    private final FindSaleByIdInputPort findSaleByIdInputPort;
    private final SaveSaleOutputPort saveSaleOutputPort;

    public FinalizeSaleUseCase(
            FindSaleByIdInputPort findSaleByIdInputPort,
            SaveSaleOutputPort saveSaleOutputPort
    ) {
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    @Override
    public void finalize(Sale sale) {
        var saleResponse = this.findSaleByIdInputPort.find(sale.getId());
        saleResponse.setStatus(SaleStatus.FINALIZED);
        saveSaleOutputPort.save(saleResponse);
    }
}
