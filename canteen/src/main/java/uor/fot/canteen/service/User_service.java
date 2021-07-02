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
}
