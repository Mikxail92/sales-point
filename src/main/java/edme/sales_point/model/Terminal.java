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
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "terminal")
public class Terminal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "terminal_id", nullable = false, length = 9)
    private String terminalId;

    @ManyToOne
    @JoinColumn(name = "mcc_id", nullable = false)
    private MerchantCategoryCode merchantCategoryCode;

    @ManyToOne
    @JoinColumn(name = "pos_id", nullable = false)
    private SalesPoint salesPoint;
}
