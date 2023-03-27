package com.tawandev.saleservice.adapters.out.message;

import com.tawandev.saleservice.application.core.domain.Sale;
import com.tawandev.saleservice.application.core.domain.enums.SaleEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SaleMessage {

    private Sale sale;

    private SaleEvent event;

}
