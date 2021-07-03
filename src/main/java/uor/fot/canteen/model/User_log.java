package uor.fot.canteen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class User_log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer log_id;

    private String user_details;
    private String user;
    private String operation;
    private LocalDateTime changed_at;


    public Integer getLog_id() {
        return log_id;
    }

    public void setLog_id(Integer log_id) {
        this.log_id = log_id;
    }

    public String getUser_details() {
        return user_details;
    }

    public void setUser_details(String user_details) {
        this.user_details = user_details;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public LocalDateTime getChanged_at() {
        return changed_at;
    }

    public void setChanged_at(LocalDateTime changed_at) {
        this.changed_at = changed_at;
    }
}
