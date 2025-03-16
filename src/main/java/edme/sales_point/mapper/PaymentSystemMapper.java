package edme.sales_point.mapper;

import edme.sales_point.dto.PaymentSystemDto;
import edme.sales_point.model.PaymentSystem;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PaymentSystemMapper {

    PaymentSystemDto toDto(PaymentSystem paymentSystem);

    PaymentSystem toEntity(PaymentSystemDto paymentSystemDto);
}
