package edme.sales_point.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor

public class JwtResponseDto {
    private String token;
}
