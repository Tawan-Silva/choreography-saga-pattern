package com.tawandev.saleservice.adapters.in.controller.mapper;

import com.tawandev.saleservice.adapters.in.controller.request.SaleRequest;
import com.tawandev.saleservice.application.core.domain.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {

    Sale toSale(SaleRequest saleRequest);
}
