package uor.fot.canteen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("admindashboard")
    public String viewAdminDash(Model model){
        return "admin/admin_dashboard";
    }
}
