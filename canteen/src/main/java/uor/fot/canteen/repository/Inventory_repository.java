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

    //admin add inventory
    @Transactional
    @Procedure(procedureName = "insert_inventory_procedure")
    void inventoryAdd(String item_id, Integer quantity);

    //admin view items from inventory
    @Query(value = "SELECT *FROM inventory", nativeQuery = true)
    List<Inventory> getAllInventoryItems();

    //admin update inventory
    @Transactional
    @Procedure(procedureName = "update_inventory_procedure")
    void adUpdateInventory(Integer inv_id, String item_id, Integer quantity);

    //delete inventory item
    @Transactional
    @Procedure(procedureName = "delete_inventory_procedure")
    void inventoryDelete(String item_id);
}
