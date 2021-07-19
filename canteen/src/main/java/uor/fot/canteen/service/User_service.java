package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import uor.fot.canteen.model.User;
import uor.fot.canteen.repository.User_repository;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class User_service {

    @Autowired
    private User_repository user_repository;

    //register user
    public void registerUser(String u_id, String u_name, String u_email, String u_password, Integer u_role, String u_contact, MultipartFile u_image){

        String fileName = StringUtils.cleanPath(u_image.getOriginalFilename());
        User user = new User();

        if (fileName.contains("..")){
            System.out.println("not a valid file");
        }
        try {
            user.setUser_image(Base64.getEncoder().encodeToString(u_image.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        user_repository.userRegister(u_id, u_name, u_email, u_password, u_role, u_contact, user.getUser_image());

    }

//    //admin add user
//    public boolean adAddUser(String u_id, String u_name, String u_email,Integer u_role){
//        user_repository.adUserCreate(u_id, u_name, u_email, u_role);
//        return true;
//    }

    //login user
    public User loginUser(String u_id, String U_password) {
        return user_repository.availableUser(u_id, U_password);
    }

    //view all users
    public List<User> getAllUsers(){
        return user_repository.getAllUsers();
    }

    //update user
    public void userUpdate(String u_id, String u_name, String U_email, String u_password,  Integer u_role, Integer u_contact, MultipartFile u_image){

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(u_image.getOriginalFilename()));
        User user = new User();

        if (fileName.contains("..")){
            System.out.println("not a valid file");
        }
        try {
            user.setUser_image(Base64.getEncoder().encodeToString(u_image.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user_repository.adUpdateUser(u_id, u_name, U_email, u_password,  u_role, u_contact, user.getUser_image());
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

    //get user image for profile
    public String getUserImage(String user_id){
        String userProfile = user_repository.getUserImage(user_id);
        return userProfile;
    }

    //get user name
    public String getUserName(String user_id){
        return user_repository.getUserName(user_id);
    }

    //get user id
    public String getUserId(String user_id){
        return user_repository.getUserId(user_id);
    }
}
