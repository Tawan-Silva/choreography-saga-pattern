package com.tawandev.inventoryservice.application.ports.in;

import com.tawandev.inventoryservice.application.core.domain.Sale;

public interface CreditInventoryInputPort {

    void credit(Sale sale);
}
