package edme.sales_point.mapper;

import edme.sales_point.dto.TransactionTypeDto;
import edme.sales_point.model.TransactionType;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TransactionTypeMapper {

    TransactionTypeDto toDto(TransactionType transactionType);

    TransactionType toEntity(TransactionTypeDto transactionTypeDto);
}
