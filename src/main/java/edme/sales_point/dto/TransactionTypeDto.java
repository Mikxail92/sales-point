package edme.sales_point.dto;

import lombok.Data;

@Data
public class TransactionTypeDto {
    private Long id;
    private String transactionTypeName;
    private String operator;
}
