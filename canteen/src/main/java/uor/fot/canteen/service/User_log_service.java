package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uor.fot.canteen.repository.User_log_repository;

import javax.transaction.Transactional;

@Service
@Transactional
public class User_log_service {

    @Autowired
    private User_log_repository user_log_repository;
}
