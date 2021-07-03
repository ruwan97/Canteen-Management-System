package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uor.fot.canteen.model.Inventory_log;

public interface Inventory_log_repository extends JpaRepository<Inventory_log, Integer> {
}
