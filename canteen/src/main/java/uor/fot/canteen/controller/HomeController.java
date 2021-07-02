package uor.fot.canteen.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {
    @RequestMapping("/")
    public String viewHomePage(Model model){
        return "home/index";
    }

}
