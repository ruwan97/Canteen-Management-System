package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uor.fot.canteen.model.Orders;
import uor.fot.canteen.model.Transaction;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface Transaction_repository extends JpaRepository<Transaction, Integer> {

    //admin view transactions
    @Query(value = "SELECT *FROM transaction", nativeQuery = true)
    List<Transaction> getAllTransaction();

    //admin confirm order user
    @Transactional
    @Procedure(procedureName = "insert_transaction_procedure")
    void cinfirmOrder(Integer order_id);

    //user view invoice
    @Transactional
    @Query(nativeQuery = true, value = "call user_view_invoice_procedure(?)")
    List<Transaction> userInvoice(@Param("u_id")String user_id);
}
