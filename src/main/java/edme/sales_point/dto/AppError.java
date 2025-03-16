package edme.sales_point.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AppError {

    private int status;
    private String name;
    private String message;
    private Date timestamp;

}