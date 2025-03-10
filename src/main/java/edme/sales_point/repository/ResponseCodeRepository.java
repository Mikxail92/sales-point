package edme.sales_point.repository;

import edme.sales_point.model.ResponseCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResponseCodeRepository extends JpaRepository<ResponseCode, Long> {
}
