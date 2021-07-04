package uor.fot.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uor.fot.canteen.model.User;
import uor.fot.canteen.service.User_service;

import java.util.Objects;

@Controller
public class User_controller {

    @Autowired
    private User_service user_service;

    //create user
    @PostMapping("/signup")
    public String addUser(@RequestParam("id") String u_id, @RequestParam("name") String u_name, @RequestParam("email") String u_email, @RequestParam("password") String u_password, @RequestParam("role") Integer u_role, @RequestParam("contact") String u_contact, @RequestParam("image") String u_image)
    {
        boolean result = user_service.addUser(u_id, u_name, u_email,u_password, u_role, u_contact, u_image);
        if (result)
            return "redirect:/login";
        else
            return "redirect:/register";
    }


    //login user
    @PostMapping("/signin")
    public String login(@RequestParam("email") String u_email, @RequestParam("password") String U_password){
        User user = user_service.loginUser(u_email, U_password);
        if (Objects.nonNull(user)) {
            Integer U_role = user.getUser_role();
            if (U_role == 1 ) {
                return "redirect:/admindashboard";
            }
            else {
                return "redirect:/userdashboard";
            }
        }
        else {
            return "redirect:login";
        }
    }

    @RequestMapping("/userdashboard")
    public String viewUserDashboard(Model model){
        return "user/user_dashboard";
    }


    //delete user
    @RequestMapping("/deleteUser/{user_id}")
    public String deleteUser(@PathVariable("user_id") String user_id){
        boolean result = user_service.deleteUser(user_id);
        if (result)
            return "redirect:/user?user_delete_done";
        else
            return "redirect:/user?user_delete_error";
    }

    //update user

}
