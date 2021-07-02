package uor.fot.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import uor.fot.canteen.service.User_service;

@Controller
public class User_controller {

    @Autowired
    private User_service user_service;
}
