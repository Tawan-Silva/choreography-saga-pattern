package com.tawandev.saleservice.adapters.out.repository.mapper;

import com.tawandev.saleservice.adapters.out.repository.entity.SaleEntity;
import com.tawandev.saleservice.application.core.domain.Sale;
import com.tawandev.saleservice.application.core.domain.enums.SaleStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface SaleEntityMapper {

    @Mapping(source = "status", target = "statusId", qualifiedByName = "setStatusId")
    SaleEntity toSaleEntity(Sale sale);

    @Named("setSatusId")
    default Integer setSatusId(SaleStatus saleStatus) {
        return saleStatus.getStatusId();
    }

    @Mapping(source = "statusId", target = "status", qualifiedByName = "setStatus")
    Sale toSale(SaleEntity saleEntity);

    @Named("setStatus")
    default SaleStatus setSatus(Integer saleSatusId) {
        return SaleStatus.toEnum(saleSatusId);
    }
}
