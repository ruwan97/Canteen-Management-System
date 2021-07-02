package uor.fot.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uor.fot.canteen.service.User_service;

@Controller
public class User_controller {

    @Autowired
    private User_service user_service;

    @PostMapping("/saveUser")
    public String addUser(@RequestParam("u_id") String u_id, @RequestParam("u_name") String u_name, @RequestParam("u_email") String u_email, @RequestParam("u_role") String u_role)
    {
        boolean res = user_service.addUser(u_id, u_name, u_email,u_role);
        if (res)
            return "redirect:/user?user_done";
        else
            return "redirect:/user?user_error";
    }
}
