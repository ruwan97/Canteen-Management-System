package uor.fot.canteen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;

    private String user_id;
    private String item_id;
    private Integer quantity;
    private Float order_amount;
    private Timestamp date_and_time;


    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(Float order_amount) {
        this.order_amount = order_amount;
    }

    public Timestamp getDate_and_time() {
        return date_and_time;
    }

    public void setDate_and_time(Timestamp date_and_time) {
        this.date_and_time = date_and_time;
    }
}
