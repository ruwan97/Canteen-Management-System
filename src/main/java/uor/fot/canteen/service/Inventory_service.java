package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uor.fot.canteen.repository.Inventory_repository;

import javax.transaction.Transactional;

@Service
@Transactional
public class Inventory_service {

    @Autowired
    private Inventory_repository inventory_repository;
}
