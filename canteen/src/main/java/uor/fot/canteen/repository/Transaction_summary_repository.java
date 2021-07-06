package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uor.fot.canteen.model.Transaction;
import uor.fot.canteen.model.Transactions_summary;

import java.util.List;

@Repository
public interface Transaction_summary_repository extends JpaRepository<Transactions_summary, Integer> {

    //admin view daily transaction summary
    @Query(value = "SELECT *FROM transactions_summary", nativeQuery = true)
    List<Transactions_summary> getDailyTransaction();
}
