package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uor.fot.canteen.model.Order_log;

public interface Order_log_repository extends JpaRepository<Order_log, Integer> {
}
