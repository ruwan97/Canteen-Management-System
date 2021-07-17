package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uor.fot.canteen.model.Orders;
import uor.fot.canteen.repository.Orders_repository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Orders_service {

    @Autowired
    private Orders_repository orders_repository;

    //user add order
    public boolean addOrder(String u_id, String Item_id, Integer quantity){
        orders_repository.addOrder(u_id, Item_id, quantity);
        return true;
    }

    //admin view orders
    public List<Orders> getAllOrders(){
        return orders_repository.getAllOrders();
    }

    //user view orders
    public List<Orders> getUserOrder(String u_id){
        List<Orders> userOrders = orders_repository.userOrders(u_id);

        return userOrders;
    }

}
