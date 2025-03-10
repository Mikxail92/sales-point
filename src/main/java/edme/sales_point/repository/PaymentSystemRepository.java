package edme.sales_point.repository;

import edme.sales_point.model.PaymentSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentSystemRepository extends JpaRepository<PaymentSystem, Long> {
}
