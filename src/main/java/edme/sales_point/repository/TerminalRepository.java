package edme.sales_point.repository;

import edme.sales_point.model.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Long> {
}
