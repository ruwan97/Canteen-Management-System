package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uor.fot.canteen.repository.User_repository;

import javax.transaction.Transactional;

@Service
@Transactional
public class User_service {

    @Autowired
    private User_repository user_repository;

    public boolean addUser(String u_id, String u_name, String u_email, String u_role){
        user_repository.usercreate(u_id, u_name, u_email, u_role);
        return true;
    }
}
