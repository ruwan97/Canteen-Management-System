package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uor.fot.canteen.model.Order_log;
import uor.fot.canteen.model.Transaction_log;

import java.util.List;

@Repository
public interface Transaction_log_repository extends JpaRepository<Transaction_log, Integer> {

    //view trannsaction log
    @Query(value = "SELECT *FROM transaction_log", nativeQuery = true)
    List<Transaction_log> getTransactionLog();
}
