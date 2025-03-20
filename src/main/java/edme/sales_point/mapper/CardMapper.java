package edme.sales_point.mapper;

import edme.sales_point.dto.CardDto;
import edme.sales_point.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface CardMapper {

    @Mapping(source = "paymentSystem.id", target = "paymentSystemId")
    CardDto toDTO(Card card);

    @Mapping(source = "paymentSystemId", target = "paymentSystem.id")
    Card toEntity(CardDto cardDTO);
}
