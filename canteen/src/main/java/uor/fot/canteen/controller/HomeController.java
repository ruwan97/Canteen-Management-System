package uor.fot.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uor.fot.canteen.model.User;
import uor.fot.canteen.service.User_service;

import java.util.Objects;

@Controller
public class HomeController {

    @Autowired
    private User_service user_service;

    @RequestMapping("/")
    public String indexPage(Model model){
        return "home/index";
    }

    @RequestMapping("/home")
    public String viewHomePage(Model model){
        return "home/index";
    }

    @RequestMapping("/about")
    public String viewaAoutPage(Model model){
        return "home/about";
    }

    @RequestMapping("/menu")
    public String viewMenuPage(Model model){
        return "home/menu";
    }

    @RequestMapping("/blog")
    public String viewBlogPage(Model model){
        return "home/blog";
    }

    @RequestMapping("/contact")
    public String viewContactPage(Model model){
        return "home/contact";
    }

    @RequestMapping("/login")
    public String viewLoginPage(Model model){
        return "home/login";
    }

    @RequestMapping("/register")
    public String viewRegisterPage(Model model){
        return "home/register";
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

}
