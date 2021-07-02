package uor.fot.canteen.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {
    @RequestMapping("/")
    public String viewHomePage(Model model){
        return "index";
    }


//    @RequestMapping("/userdash")
//    public String viewUserDash(Model model){
//        return "user/user_dashboard";
//    }
}
