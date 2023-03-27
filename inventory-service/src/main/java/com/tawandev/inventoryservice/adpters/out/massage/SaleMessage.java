package com.tawandev.inventoryservice.adpters.out.massage;

import com.tawandev.inventoryservice.application.core.domain.Sale;
import com.tawandev.inventoryservice.application.core.domain.enums.SaleEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleMessage {

    private Sale sale;
    private SaleEvent event;
}
