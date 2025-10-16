package poly.edu.dao.lab6;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.edu.model.lab6.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}