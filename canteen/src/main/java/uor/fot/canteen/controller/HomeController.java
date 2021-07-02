package uor.fot.canteen.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {
    @RequestMapping("/")
    public String viewHomePage(Model model){
        return "login.html";
    }

    @RequestMapping("/admindashboard")
    public String viewAdminDash(Model model){
        return "admin/admin_dashboard.html";
    }

    @RequestMapping("/userdashboard")
    public String viewUserDash(Model model){
        return "user/user_dashboard.html";
    }
}
