package uor.fot.canteen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

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



}
