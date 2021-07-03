package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uor.fot.canteen.repository.Transaction_repository;

import javax.transaction.Transactional;

@Service
@Transactional
public class Transaction_service {

    @Autowired
    private Transaction_repository transaction_repository;
}
