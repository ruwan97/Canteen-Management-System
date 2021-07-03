package uor.fot.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import uor.fot.canteen.service.User_log_service;

@Controller
public class User_log_controller {

    @Autowired
    private User_log_service user_log_service;
}
