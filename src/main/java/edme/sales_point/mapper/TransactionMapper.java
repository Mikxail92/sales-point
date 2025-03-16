package edme.sales_point.mapper;

import edme.sales_point.dto.TransactionDTO;
import edme.sales_point.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {TransactionMapper.class, CardMapper.class, TerminalMapper.class, ResponseCodeMapper.class})
public interface TransactionMapper {

    @Mapping(source = "transactionType.id", target = "transactionTypeId")
    @Mapping(source = "card.id", target = "cardId")
    @Mapping(source = "terminal.id", target = "terminalId")
    @Mapping(source = "responseCode.id", target = "responseCodeId")
    TransactionDTO toDTO(Transaction transaction);

    @Mapping(source = "transactionTypeId", target = "transactionType.id")
    @Mapping(source = "cardId", target = "card.id")
    @Mapping(source = "terminalId", target = "terminal.id")
    @Mapping(source = "responseCodeId", target = "responseCode.id")
    Transaction toEntity(TransactionDTO transactionDTO);
}
