package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uor.fot.canteen.repository.Inventory_log_repository;

import javax.transaction.Transactional;

@Service
@Transactional
public class Inventory_log_service {

    @Autowired
    private Inventory_log_repository inventory_log_repository;
}
