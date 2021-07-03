package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uor.fot.canteen.repository.Transaction_summary_repository;

import javax.transaction.Transactional;

@Service
@Transactional
public class Transactions_summary_service {

    @Autowired
    private Transaction_summary_repository transaction_summary_repository;
}
