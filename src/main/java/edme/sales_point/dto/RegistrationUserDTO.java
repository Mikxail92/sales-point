package edme.sales_point.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegistrationUserDTO {

    private Long id;

    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Логин может содержать только буквы и цифры")
    @NotBlank(message = "Логин не может быть пустым или содержать только пробелы")
    @Size(min = 2, max = 10, message = "Длина строки должна быть от 2 до 10 символов")
    private String userLogin;


    @NotBlank(message = "Пароль не может быть пустым или содержать только пробелы")
    @Size(min = 2, max = 10, message = "Длина пароля должна быть от 2 до 10 символов")
    private String userPassword;
    private String fullName;
}