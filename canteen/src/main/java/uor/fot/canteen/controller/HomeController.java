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

    @RequestMapping("/home/about")
    public String viewaAoutPage(Model model){
        return "home/about";
    }

    @RequestMapping("/home/menu")
    public String viewMenuPage(Model model){
        return "home/menu";
    }

    @RequestMapping("/home/blog")
    public String viewBlogPage(Model model){
        return "home/blog";
    }

    @RequestMapping("/home/contact")
    public String viewContactPage(Model model){
        return "home/contact";
    }

    @RequestMapping("/home/login")
    public String viewLoginPage(Model model){
        return "home/login";
    }

    @RequestMapping("/home/register")
    public String viewRegisterPage(Model model){
        return "home/register";
    }

    //after login and register
//    @RequestMapping("/home/signin")
//    public String afterSignIn(Model model){
//        return "redirect:/index";
//    }
//
//    @RequestMapping("/home/signup")
//    public String afterSignUp(Model model){
//        return "redirect:/login";
//    }

}
