package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import uor.fot.canteen.model.Orders;

@Repository
public interface Orders_repository extends JpaRepository<Orders, Integer > {

    //user view orders
    @Procedure(procedureName = "user_view_orders_procedure")
    void getuserViwOrders(String user_id);
}
