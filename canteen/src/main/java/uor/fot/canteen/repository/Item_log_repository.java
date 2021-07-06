package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uor.fot.canteen.model.Item_log;
import uor.fot.canteen.model.Order_log;

import java.util.List;

@Repository
public interface Item_log_repository extends JpaRepository<Item_log, Integer> {

    //view item log
    @Query(value = "SELECT *FROM item_log", nativeQuery = true)
    List<Item_log> getItemLog();
}
