package edme.sales_point.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_number", nullable = false, length = 50)
    private String cardNumber;

    @Column(name = "expiration_date", nullable = false)
    private Date expirationDate;

    @Column(name = "holder_name", nullable = false, length = 50)
    private String holderName;

    @ManyToOne
    @JoinColumn(name = "payment_system_id", nullable = false)
    private PaymentSystem paymentSystem;
}