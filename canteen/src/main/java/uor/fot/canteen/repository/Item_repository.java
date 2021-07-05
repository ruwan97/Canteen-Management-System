package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import uor.fot.canteen.model.Item;
import uor.fot.canteen.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface Item_repository extends JpaRepository<Item, String> {

    //admin view items
    @Query(value = "SELECT *FROM ad_view_items", nativeQuery = true)
    List<Item> getAllItems();

    //admin update item
    @Transactional
    @Procedure(procedureName = "update_item_procedure")
    void adUpdateItem(String item_id, String item_name, Float unit_price);
}
