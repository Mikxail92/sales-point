package edme.sales_point.exception;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AppResponseError {

    private int status;
    private String name;
    private String message;
    private Date timestamp;

}