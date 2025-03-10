package edme.sales_point.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_access")
public class UserAccess {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Уникальный идентификатор пользователя

    @Column(name = "user_login", nullable = false, length = 255)
    private String userLogin;  // Логин пользователя

    @Column(name = "user_password", nullable = false, length = 255)
    private String userPassword;  // Хэшированный пароль пользователя

    @Column(name = "full_name", nullable = false, length = 255)
    private String fullName;  // Полное имя пользователя

    @Column(name = "user_role", nullable = false, length = 255)
    private String userRole;  // Роль пользователя
}