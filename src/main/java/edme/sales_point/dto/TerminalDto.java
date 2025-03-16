package edme.sales_point.dto;

import lombok.Data;

@Data
public class TerminalDto {
    private Long id;
    private String terminalId;
    private Long merchantCategoryCodeId; // ID of MerchantCategoryCode
    private Long salesPointId; // ID of SalesPoint
}
