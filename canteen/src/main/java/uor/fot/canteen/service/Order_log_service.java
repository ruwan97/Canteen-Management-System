package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uor.fot.canteen.repository.Order_log_repository;

import javax.transaction.Transactional;

@Service
@Transactional
public class Order_log_service {

    @Autowired
    private Order_log_repository order_log_repository;
}
