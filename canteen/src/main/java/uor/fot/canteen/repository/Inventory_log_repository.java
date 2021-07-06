package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uor.fot.canteen.model.Inventory;
import uor.fot.canteen.model.Inventory_log;
import uor.fot.canteen.model.Order_log;

import java.util.List;

@Repository
public interface Inventory_log_repository extends JpaRepository<Inventory_log, Integer> {

    //view inventory log
    @Query(value = "SELECT *FROM inventory_log", nativeQuery = true)
    List<Inventory_log> getInventoryLog();
}
