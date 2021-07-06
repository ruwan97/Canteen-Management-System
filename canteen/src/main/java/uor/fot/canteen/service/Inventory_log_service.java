package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uor.fot.canteen.model.Inventory_log;
import uor.fot.canteen.model.Order_log;
import uor.fot.canteen.repository.Inventory_log_repository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Inventory_log_service {

    @Autowired
    private Inventory_log_repository inventory_log_repository;

    //view inventory log
    public List<Inventory_log> getInventoryLog(){
        return inventory_log_repository.getInventoryLog();
    }
}
