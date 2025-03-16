package edme.sales_point.repository;

import edme.sales_point.model.AcquiringBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AcquiringBankRepository extends JpaRepository<AcquiringBank, Long> {

}
