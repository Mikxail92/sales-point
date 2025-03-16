package edme.sales_point.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@Table(name = "acquiring_bank")
public class AcquiringBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bic", nullable = false, length = 9)
    private String bic;

    @Column(name = "abbreviated_name", nullable = false)
    private String abbreviatedName;

}
