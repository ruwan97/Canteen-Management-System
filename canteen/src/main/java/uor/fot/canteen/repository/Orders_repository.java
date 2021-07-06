package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import uor.fot.canteen.model.Item;
import uor.fot.canteen.model.Orders;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface Orders_repository extends JpaRepository<Orders, Integer > {

    //admin view all orders
    @Query(value = "SELECT *FROM ad_view_orders", nativeQuery = true)
    List<Orders> getAllOrders();

    //user view orders
    @Procedure(procedureName = "user_view_orders_procedure")
    void getuserViwOrders(String user_id);

    //user add order
    @Transactional
    @Procedure(procedureName = "insert_order_procedure")
    void addOrder(String u_name, String item_name, Integer quantity);


}
