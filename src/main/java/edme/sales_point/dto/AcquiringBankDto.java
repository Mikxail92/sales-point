package edme.sales_point.dto;

import lombok.Data;

@Data
public class AcquiringBankDto {
    private Long id;
    private String bic;
    private String abbreviatedName;
}

