package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uor.fot.canteen.model.User;
import uor.fot.canteen.repository.User_repository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class User_service {

    @Autowired
    private User_repository user_repository;

    //register user
    public boolean registerUser(String u_id, String u_name, String u_email, String u_password, Integer u_role, String u_contact, String u_image){
        user_repository.userRegister(u_id, u_name, u_email, u_password, u_role, u_contact, u_image);
        return true;
    }

//    //admin add user
//    public boolean adAddUser(String u_id, String u_name, String u_email,Integer u_role){
//        user_repository.adUserCreate(u_id, u_name, u_email, u_role);
//        return true;
//    }

    //login user
    public User loginUser(String u_email, String U_password) {
        return user_repository.availableUser(u_email, U_password);
    }

    //view all users
    public List<User> getAllUsers(){
        return user_repository.getAllUsers();
    }

    //update user
    public void userUpdate(String u_id, String u_name, String U_email, String u_password,  Integer u_role, Integer u_contact, String u_image){
        user_repository.adUpdateUser(u_id, u_name, U_email, u_password,  u_role, u_contact, u_image);
    }

    //get user
    public User getUser(String u_id){
        return user_repository.findById(u_id).get();
    }

    //delete user
    public boolean deleteUser(String user_id){
        user_repository.userDelete(user_id);
        return true;
    }
}
