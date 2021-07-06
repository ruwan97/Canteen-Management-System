package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uor.fot.canteen.model.Order_log;
import uor.fot.canteen.model.Transaction_log;
import uor.fot.canteen.repository.Transaction_log_repository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Transaction_log_service {

    @Autowired
    private Transaction_log_repository transaction_log_repository;

    //view transaction log
    public List<Transaction_log> getTransactionLog(){
        return transaction_log_repository.getTransactionLog();
    }
}
