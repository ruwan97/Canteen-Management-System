package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import uor.fot.canteen.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface User_repository extends JpaRepository<User, String> {

    @Transactional

    //insert user procedure
    @Procedure(procedureName = "ad_user_account_create_procedure")
    void usercreate(String user_id, String user_name, String user_email, String user_role);

    //get all users
    @Query(value = "SELECT u FROM User u")
    List<User> getAllUsers();

}
