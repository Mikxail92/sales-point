package edme.sales_point.mapper;

import edme.sales_point.dto.SalesPointDto;
import edme.sales_point.model.SalesPoint;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface SalesPointMapper {

    SalesPointDto toDto(SalesPoint salesPoint);

    SalesPoint toEntity(SalesPointDto salesPointDto);
}
