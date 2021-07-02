package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uor.fot.canteen.model.Inventory;

public interface Inventory_repository extends JpaRepository<Inventory, Integer> {
}
