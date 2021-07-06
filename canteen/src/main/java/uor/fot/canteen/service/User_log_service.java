package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uor.fot.canteen.model.User;
import uor.fot.canteen.model.User_log;
import uor.fot.canteen.repository.User_log_repository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class User_log_service {

    @Autowired
    private User_log_repository user_log_repository;

    //view user log
    public List<User_log> getUserLog(){
        return user_log_repository.getUserLog();
    }
}
