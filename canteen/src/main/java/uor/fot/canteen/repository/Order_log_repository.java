package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uor.fot.canteen.model.Order_log;
import uor.fot.canteen.model.User_log;

import java.util.List;

@Repository
public interface Order_log_repository extends JpaRepository<Order_log, Integer> {

    //view user log
    @Query(value = "SELECT *FROM order_log", nativeQuery = true)
    List<Order_log> getOrderLog();
}
