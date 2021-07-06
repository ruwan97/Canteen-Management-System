package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uor.fot.canteen.model.Orders;
import uor.fot.canteen.model.Transaction;

import java.util.List;

@Repository
public interface Transaction_repository extends JpaRepository<Transaction, Integer> {

    //admin view transactions
    @Query(value = "SELECT *FROM transaction", nativeQuery = true)
    List<Transaction> getAllTransaction();
}
