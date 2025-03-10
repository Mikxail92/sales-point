package edme.sales_point.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@Table(name = "sales_point")
public class SalesPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pos_name", nullable = false)
    private String posName;

    @Column(name = "pos_address", nullable = false)
    private String posAddress;

    @Column(name = "pos_inn", nullable = false, length = 12)
    private String posInn;

    @ManyToOne
    @JoinColumn(name = "acquiring_bank_id", nullable = false, referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_acquiring_bank"))
    private AcquiringBank acquiringBank;
}
