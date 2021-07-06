package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uor.fot.canteen.model.Inventory;
import uor.fot.canteen.model.User;
import uor.fot.canteen.repository.Inventory_repository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Inventory_service {

    @Autowired
    private Inventory_repository inventory_repository;

    //vite inventory items
    public List<Inventory> getAllInventoryItems(){
        return inventory_repository.getAllInventoryItems();
    }

    //delete inventory item
    public boolean deleteInventory(String item_id){
        inventory_repository.inventoryDelete(item_id);
        return true;
    }

    //get item id
//    public Inventory getItem(String item_id){
//        return inventory_repository.getById(item_id).get();
//    }
}
