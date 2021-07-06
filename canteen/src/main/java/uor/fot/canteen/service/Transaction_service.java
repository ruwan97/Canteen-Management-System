package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uor.fot.canteen.model.Orders;
import uor.fot.canteen.model.Transaction;
import uor.fot.canteen.repository.Transaction_repository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Transaction_service {

    @Autowired
    private Transaction_repository transaction_repository;

    //admin view transactions
    public List<Transaction> getAllTransactions(){
        return transaction_repository.getAllTransaction();
    }

    //admin confirm order
    public boolean confirmOrder(Integer order_id){
        transaction_repository.cinfirmOrder(order_id);
        return true;
    }
}
