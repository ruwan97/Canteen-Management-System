package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uor.fot.canteen.model.Transaction_log;

public interface Transaction_log_repository extends JpaRepository<Transaction_log, Integer> {
}
