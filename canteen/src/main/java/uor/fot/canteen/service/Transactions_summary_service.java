package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uor.fot.canteen.model.Transaction;
import uor.fot.canteen.model.Transactions_summary;
import uor.fot.canteen.repository.Transaction_summary_repository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Transactions_summary_service {

    @Autowired
    private Transaction_summary_repository transaction_summary_repository;

    //admin view daily transactions
    public List<Transactions_summary> getDailyTransactions(){
        return transaction_summary_repository.getDailyTransaction();
    }
}
