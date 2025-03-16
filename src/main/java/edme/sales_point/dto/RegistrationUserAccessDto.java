package edme.sales_point.dto;

import lombok.Data;

@Data
public class RegistrationUserAccessDto {

    private String Login;
    private String Password;
    private String confirmPassword;
    private String email;
    private String firstName;
    private String lastName;
}