package edme.sales_point.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.sql.Date;
@Data
//@RedisHash("Cards")
//@JsonFormat(shape = JsonFormat.Shape.STRING)
public class CardDto implements Serializable {

    private Long id;
    private String cardNumber;
    private Date expirationDate;
    private String holderName;
    private Long paymentSystemId;
}
