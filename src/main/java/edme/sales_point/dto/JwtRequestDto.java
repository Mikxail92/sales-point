package edme.sales_point.dto;

import lombok.Data;

@Data
public class JwtRequestDto {

    private String userLogin;
    private String userPassword;
}