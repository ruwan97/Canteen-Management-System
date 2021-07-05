package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import uor.fot.canteen.model.Orders;

public interface Orders_repository extends JpaRepository<Orders, Integer > {

    //user view orders
    @Procedure(procedureName = "user_view_orders_procedure")
    void getuserViwOrders(String user_id);
}
