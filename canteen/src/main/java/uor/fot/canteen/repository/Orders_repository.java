package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uor.fot.canteen.model.Orders;

public interface Orders_repository extends JpaRepository<Orders, Integer > {
}
