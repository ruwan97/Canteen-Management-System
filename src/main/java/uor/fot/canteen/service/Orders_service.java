package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uor.fot.canteen.repository.Orders_repository;

import javax.transaction.Transactional;

@Service
@Transactional
public class Orders_service {

    @Autowired
    private Orders_repository orders_repository;
}
