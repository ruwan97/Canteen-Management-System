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

    //create user
    public boolean addUser(String u_id, String u_name, String u_email, String u_password, String u_role, String u_contact, String u_image){
        user_repository.userCreate(u_id, u_name, u_email, u_password, u_role, u_contact, u_image);
        return true;
    }

    //login user
    public User loginUser(String U_name, String U_password) {
        return user_repository.availableUser(U_name, U_password);
    }

//    public List<User> getAllUsers(){
//        return user_repository.getAllUsers();
//    }

    //delete user
    public boolean deleteUser(String user_id){
        user_repository.userDelete(user_id);
        return true;
    }
}
