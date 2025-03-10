package edme.sales_point.repository;

import edme.sales_point.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long> {
}
