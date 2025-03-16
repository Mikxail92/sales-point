package edme.sales_point.mapper;

import edme.sales_point.dto.AcquiringBankDto;
import edme.sales_point.model.AcquiringBank;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface AcquiringBankMapper {


    AcquiringBankDto toDto(AcquiringBank acquiringBank);

    AcquiringBank toEntity(AcquiringBankDto acquiringBankDto);
}
