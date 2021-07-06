package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import uor.fot.canteen.model.Inventory;
import uor.fot.canteen.model.Item;
import uor.fot.canteen.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface Item_repository extends JpaRepository<Item, String> {

    //admin add item
    @Transactional
    @Procedure(procedureName = "insert_item_procedure")
    void itemAdd(String item_id, String item_name, Float item_price, String item_image);

    //view all items
    @Query(value = "SELECT *FROM view_all_items", nativeQuery = true)
    List<Item> getAllItems();

    //admin update item
    @Transactional
    @Procedure(procedureName = "update_item_procedure")
    void adUpdateItem(String item_id, String item_name, Float unit_price, String item_image);

    //delete item
    @Transactional
    @Procedure(procedureName = "delete_item_procedure")
    void itemDelete(String item_id);

}
