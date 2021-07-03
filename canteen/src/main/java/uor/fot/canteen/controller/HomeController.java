package uor.fot.canteen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String viewHomePage(Model model){
        return "home/index";
    }

    @RequestMapping("/home")
    public String homePage(Model model){
        return "home/index";
    }

    @RequestMapping("/home/login")
    public String viewLoginPage(Model model){
        return "home/login";
    }

    @RequestMapping("/home/register")
    public String viewRegisterPage(Model model){
        return "home/register";
    }

}
