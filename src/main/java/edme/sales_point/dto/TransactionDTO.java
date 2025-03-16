package edme.sales_point.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
@Data
public class TransactionDTO {
    private Long id;
    private LocalDate transactionDate;
    private BigDecimal sum;
    private Long transactionTypeId;
    private Long cardId;
    private Long terminalId;
    private Long responseCodeId;
    private String authorizationCode;
}
