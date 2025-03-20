package edme.sales_point.dto;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.sql.Date;
@Data
//@RedisHash("Cards")
public class CardDto implements Serializable {

    private Long id;
    private String cardNumber;
    private Date expirationDate;
    private String holderName;
    private Long paymentSystemId;
}
