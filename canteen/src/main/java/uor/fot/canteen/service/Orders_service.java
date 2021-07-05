package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uor.fot.canteen.model.Item;
import uor.fot.canteen.model.Orders;
import uor.fot.canteen.model.User;
import uor.fot.canteen.repository.Orders_repository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Orders_service {

    @Autowired
    private Orders_repository orders_repository;

    //admin view all items
//    public List<Orders> getAllUserOrders{
//        return orders_repository.getuserViwOrders(String user_id);
//    }

    //user add order
    public boolean addOrder(String u_id, String Item_id, Integer quantity){
        orders_repository.addOrder(u_id, Item_id, quantity);
        return true;
    }
}
