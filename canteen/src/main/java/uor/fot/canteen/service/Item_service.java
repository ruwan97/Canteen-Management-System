package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uor.fot.canteen.model.Inventory;
import uor.fot.canteen.model.Item;
import uor.fot.canteen.model.User;
import uor.fot.canteen.repository.Item_repository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Item_service {

    @Autowired
    private Item_repository item_repository;

    //admin view all items
    public List<Item> getAllItems(){
        return item_repository.getAllItems();
    }

    //update item
    public void adItemUpdate(String item_id, String item_name, Float unit_price, String item_image){
        item_repository.adUpdateItem(item_id, item_name, unit_price, item_image);
    }

    //get item
    public Item getItem(String item_id){
        return item_repository.findById(item_id).get();
    }

    //user view all items
    public List<Item> getUserItems(){
        return item_repository.getUserItems();
    }


}
