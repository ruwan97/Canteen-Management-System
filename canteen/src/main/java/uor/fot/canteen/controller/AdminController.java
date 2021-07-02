package uor.fot.canteen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/admindash")
    public String viewAdminDash(){
        return "admin/admin_dashboard";
    }
}
