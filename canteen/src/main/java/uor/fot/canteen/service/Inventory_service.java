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

    //admin add inventory
    public boolean addInventory(String item_id, Integer quantity){
        inventory_repository.inventoryAdd(item_id, quantity);
        return true;
    }

    //view inventory items
    public List<Inventory> getAllInventoryItems(){
        return inventory_repository.getAllInventoryItems();
    }

    //update inventory
    public void adInventoryUpdate(Integer inv_id, String item_id, Integer quantity){
        inventory_repository.adUpdateInventory(inv_id, item_id, quantity);
    }

    //delete inventory item
    public boolean deleteInventory(String item_id){
        inventory_repository.inventoryDelete(item_id);
        return true;
    }

    //get item id
    public Inventory getItem(Integer id){
        return inventory_repository.findById(id).get();
    }
}
