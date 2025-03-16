package edme.sales_point.mapper;

import edme.sales_point.dto.MerchantCategoryCodeDto;
import edme.sales_point.model.MerchantCategoryCode;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MerchantCategoryCodeMapper {

    MerchantCategoryCodeDto toDto(MerchantCategoryCode merchantCategoryCode);

    MerchantCategoryCode toEntity(MerchantCategoryCodeDto merchantCategoryCodeDto);
}
