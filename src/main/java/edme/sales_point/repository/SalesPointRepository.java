package edme.sales_point.repository;

import edme.sales_point.model.SalesPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalesPointRepository extends JpaRepository<SalesPoint, Long> {
}
