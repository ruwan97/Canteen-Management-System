package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uor.fot.canteen.model.Item;
import uor.fot.canteen.model.User;

import java.util.List;

@Repository
public interface Item_repository extends JpaRepository<Item, String> {

    //view items
    @Query(value = "SELECT *FROM ad_view_items", nativeQuery = true)
    List<Item> getAllItems();
}
