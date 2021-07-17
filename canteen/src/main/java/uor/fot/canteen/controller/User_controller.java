package uor.fot.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uor.fot.canteen.model.Item;
import uor.fot.canteen.model.Orders;
import uor.fot.canteen.service.Item_service;
import uor.fot.canteen.service.Orders_service;
import uor.fot.canteen.service.User_service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class User_controller {

    @Autowired
    private User_service user_service;

    @Autowired
    private Item_service item_service;

    @Autowired
    private Orders_service orders_service;

    //register user
    @PostMapping("/signup")
    public String registerUser(@RequestParam("id") String u_id, @RequestParam("name") String u_name, @RequestParam("email") String u_email, @RequestParam("password") String u_password, @RequestParam("role") Integer u_role, @RequestParam("contact") String u_contact, @RequestParam("image") MultipartFile u_image)
    {
        user_service.registerUser(u_id, u_name, u_email,u_password, u_role, u_contact, u_image);

        return "redirect:/login";
    }


    @RequestMapping("/userdashboard")
    public String viewUserDashboard(Model model){
        return "user/user_dashboard";
    }


    @RequestMapping("/userdashboard/order/view")
    public String viewUserOrders(Model model, HttpSession session){

        List<String> user_id = (List<String>) session.getAttribute("SESSION_UID");
        if (user_id == null) {
            user_id = new ArrayList<>();
        }

        for (String u_id : user_id) {
            List<Orders> userOrders = orders_service.getUserOrder(u_id);
            model.addAttribute("userOrders",userOrders);
        }

        return "user/user_view_orders";
    }



    //user view items
    @RequestMapping("/userdashboard/items/view")
    public String viewItems(Model model){
        List<Item> items = item_service.getAllItems();
//        List<Inventory> inventories = inventory_service.getAllInventoryItems();
        model.addAttribute("viewitems", items);
//        model.addAttribute("viewitems", inventories);
        return "user/user_view_items";
    }

    //user order add form
    @RequestMapping("/userdashboard/order/add/{id}")
    public String viewItemAddForm(Model model, @PathVariable("id") String item_id){
        Item item = item_service.getItem(item_id);
        model.addAttribute("viewitems", item);
        return "user/user_add_order";
    }

    //user add order
    @PostMapping("/addOrder")
    public String adOrder(@RequestParam("u_id") String user_id, @RequestParam("item_id") String item_id, @RequestParam("quantiry") Integer quantity)
    {
        boolean result = orders_service.addOrder(user_id, item_id,quantity);
        if (result)
            return "redirect:/userdashboard/order/view";
        else
            return "user/user_add_order";
    }

}
