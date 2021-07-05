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

    //register user
    @Transactional
    @Procedure(procedureName = "user_account_create_procedure")
    void userRegister(String user_id, String user_name, String user_email, String user_password, Integer user_role, String user_contact, String user_image);

//    //admin add user
//    @Transactional
//    @Procedure(procedureName = "user_account_create_procedure")
//    void adUserCreate(String user_id, String u_name, String u_email, Integer u_role);

    //login user
    @Query(value = "SELECT u FROM User u WHERE u.user_email=?1 AND u.user_password=?2")
    User availableUser(String user_email, String user_password);

    //get all users
    @Query(value = "SELECT *FROM ad_view_users", nativeQuery = true)
    List<User> getAllUsers();

    //admin update users
    @Transactional
    @Procedure(procedureName = "user_account_update_procedure")
    void adUpdateUser(String user_id, String user_name, String user_email, String user_password, Integer user_role, Integer user_contact, String user_image);

    //delete user
    @Transactional
    @Procedure(procedureName = "user_account_delete_procedure")
    void userDelete(String user_id);

}
