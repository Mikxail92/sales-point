package edme.sales_point.dto;

import lombok.Data;

import java.sql.Date;
@Data
public class CardDTO {

    private Long id;
    private String cardNumber;
    private Date expirationDate;
    private String holderName;
    private Long paymentSystemId;
}
