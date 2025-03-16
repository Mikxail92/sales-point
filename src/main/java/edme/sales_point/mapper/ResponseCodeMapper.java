package edme.sales_point.mapper;

import edme.sales_point.dto.ResponseCodeDto;
import edme.sales_point.model.ResponseCode;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ResponseCodeMapper {

    ResponseCodeDto toDto(ResponseCode responseCode);

    ResponseCode toEntity(ResponseCodeDto responseCodeDto);
}
