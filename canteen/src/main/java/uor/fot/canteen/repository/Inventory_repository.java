package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import uor.fot.canteen.model.Inventory;
import uor.fot.canteen.model.Item;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface Inventory_repository extends JpaRepository<Inventory, Integer> {

    //admin view items from inventory
    @Query(value = "SELECT *FROM ad_view_inventory", nativeQuery = true)
    List<Inventory> getAllInventoryItems();

    //delete inventory item
    @Transactional
    @Procedure(procedureName = "delete_inventory_procedure")
    void inventoryDelete(String item_id);
}
