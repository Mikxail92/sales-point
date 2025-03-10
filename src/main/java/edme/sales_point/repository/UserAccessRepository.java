package edme.sales_point.repository;

import edme.sales_point.model.UserAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserAccessRepository extends JpaRepository<UserAccess, Long> {

    Optional<UserAccess> findByUserLogin(String userLogin);
    boolean existsByUserLogin(String userLogin);
}
