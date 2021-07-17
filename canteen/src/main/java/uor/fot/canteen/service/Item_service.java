package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import uor.fot.canteen.model.Inventory;
import uor.fot.canteen.model.Item;
import uor.fot.canteen.model.User;
import uor.fot.canteen.repository.Item_repository;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class Item_service {

    @Autowired
    private Item_repository item_repository;

    //admin add item
    public void addItem(String item_id, String item_name, Float unit_price, MultipartFile item_image){

        String fileName = StringUtils.cleanPath(item_image.getOriginalFilename());
        Item item = new Item();

        if (fileName.contains("..")){
            System.out.println("not a valid file");
        }
        try {
            item.setItem_image(Base64.getEncoder().encodeToString(item_image.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        item_repository.itemAdd(item_id, item_name, unit_price, item.getItem_image());

    }

    //view all items
    public List<Item> getAllItems(){
        return item_repository.getAllItems();
    }

    //update item
    public void adItemUpdate(String item_id, String item_name, Float unit_price, MultipartFile item_image){

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(item_image.getOriginalFilename()));
        Item item = new Item();

        if (fileName.contains("..")){
            System.out.println("not a valid file");
        }
        try {
            item.setItem_image(Base64.getEncoder().encodeToString(item_image.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        item_repository.adUpdateItem(item_id, item_name, unit_price, item.getItem_image());
    }

    //delete user
    public boolean deleteItem(String item_id){
        item_repository.itemDelete(item_id);
        return true;
    }

    //get item
    public Item getItem(String item_id){
        return item_repository.findById(item_id).get();
    }

}
