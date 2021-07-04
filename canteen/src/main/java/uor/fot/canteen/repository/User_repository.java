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

    //insert user procedure
    @Transactional
    @Procedure(procedureName = "user_account_create_procedure")
    void userCreate(String user_id, String user_name, String user_email, String user_password, String user_role, String user_contact, String user_image);

    //login user
    @Query(value = "SELECT u FROM User u WHERE u.user_id=?1 AND u.user_password=?2")
    User availableUser(String user_id, String user_password);

//    //get all users
//    @Query(value = "SELECT u FROM User u")
//    List<User> getAllUsers();

    //delete user procedure
    @Transactional
    @Procedure(procedureName = "user_account_delete_procedure")
    void userDelete(String user_id);

    //update user procedure

}