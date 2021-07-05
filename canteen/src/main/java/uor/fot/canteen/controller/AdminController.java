package uor.fot.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uor.fot.canteen.model.Item;
import uor.fot.canteen.model.User;
import uor.fot.canteen.service.Item_service;
import uor.fot.canteen.service.User_service;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private User_service user_service;
    @Autowired
    private Item_service item_service;

    @RequestMapping("/admindashboard")
    public String viewAdminDash(Model model){
        return "admin/admin_dashboard";
    }

    //admin view users
    @RequestMapping("/admindashboard/user/view")
    public String viewUsers(Model model){
        List<User> users = user_service.getAllUsers();
        model.addAttribute("viewusers", users);
        return "admin/users";
    }

    //admin add user
    @PostMapping("/admindashboard/user/add")
    public String addUser(@RequestParam("id") String u_id, @RequestParam("name") String u_name, @RequestParam("email") String u_email, @RequestParam("role") Integer u_role)
    {
        boolean result = user_service.adAddUser(u_id, u_name, u_email, u_role);
        if (result)
            return "redirect:/admindashboard/user/view";
        else
            return "redirect:/admindashboard/user/add";
    }

    //admin delete user
    @RequestMapping("/admindashboard/user/delete/{id}")
    public String deleteUser(@PathVariable("id") String user_id){
        boolean result = user_service.deleteUser(user_id);
        if (result)
            return "redirect:/admindashboard/user/view";
        else
            return "redirect:/admindashboard/user/view";
    }

    //admin update uesr view
    @RequestMapping("/admindashboard/user/update")
    public String viewUserUpdate(Model model){
        List<User> users = user_service.getAllUsers();
        model.addAttribute("viewusers", users);
        return "admin/user_update";
    }

    //admin user update form
    @RequestMapping("/admindashboard/user/updateform/{id}")
    public String viewUserUpdateForm(Model model, @PathVariable("id") String u_id){
        User user = user_service.getUser(u_id);
        model.addAttribute("updateuser", user);
        return "admin/user_update_form";
    }

    //admin update user
    @PostMapping("/userupdate")
    public String adUpdateUsers(@RequestParam("id") String u_id, @RequestParam("name") String u_name, @RequestParam("email") String u_email, @RequestParam("role") Integer u_role){
        user_service.userUpdate(u_id, u_name, u_email, u_role);
        return "redirect:/admindashboard/user/view";
    }


    //admin add item
    @RequestMapping("/admindashboard/item/add")
    public String addItem(@RequestParam("id") String item_id, @RequestParam("name") String item_name, @RequestParam("price") Float unit_price, @RequestParam("image") String item_image)
    {
        boolean result = item_service.addItem(item_id, item_name, unit_price, item_image);
        if (result)
            return "redirect:/admindashboard/items/view";
        else
            return "redirect:/admindashboard/item/add";
    }

    //admin view items
    @RequestMapping("/admindashboard/items/view")
    public String viewItems(Model model){
        List<Item> items = item_service.getAllItems();
//        List<Inventory> inventories = inventory_service.getAllInventoryItems();
        model.addAttribute("viewitems", items);
//        model.addAttribute("viewitems", inventories);
        return "admin/items";
    }

    //admin item update view
    @RequestMapping("/admindashboard/item/update")
    public String viewItemUpdate(Model model){
        List<Item> items = item_service.getAllItems();
        model.addAttribute("viewitems", items);
        return "admin/item_update";
    }

    //admin item update form
    @RequestMapping("/admindashboard/item/updateform/{id}")
    public String viewItemUpdateForm(Model model, @PathVariable("id") String item_id){
        Item item = item_service.getItem(item_id);
        model.addAttribute("updateitem", item);
        return "admin/item_update_form";
    }

    //ad update item
    @PostMapping("/itemupdate")
    public String adUdpdateItems(@RequestParam("id") String item_id, @RequestParam("name") String item_name, @RequestParam("price") Float unit_price, @RequestParam("image") String item_image){
        item_service.adItemUpdate(item_id, item_name, unit_price, item_image);
        return "redirect:/admindashboard/items/view";
    }


    //inventory
    @RequestMapping("/admindashboard/inventory/view")
    public String viewInventory(Model model){
        return "admin/inventory";
    }

    @RequestMapping("/admindashboard/inventory/add")
    public String viewInventoryAdd(Model model){
        return "admin/inventory_add";
    }

    @RequestMapping("/admindashboard/inventory/update")
    public String viewInventoryUpdate(Model model){
        return "admin/inventory_update";
    }

    @RequestMapping("/admindashboard/inventory/updateform")
    public String viewInventoryUpdateForm(Model model){
        return "admin/inv_update_form";
    }

    //order
    @RequestMapping("/admindashboard/orders/view")
    public String viewOrders(Model model){
        return "admin/orders";
    }

    //transaction
    @RequestMapping("/admindashboard/transaction/view")
    public String viewTransactions(Model model){
        return "admin/transactions";
    }

    @RequestMapping("/admindashboard/transaction/viewsummary")
    public String viewTransactionsSummary(Model model){
        return "admin/transactions_summary";
    }

    //logs
    @RequestMapping("/admindashboard/logs/userlog/view")
    public String viewUserLog(Model model){
        return "admin/user_log";
    }

    @RequestMapping("/admindashboard/logs/oredrlog/view")
    public String viewOrderLog(Model model){
        return "admin/order_log";
    }

    @RequestMapping("/admindashboard/logs/itemlog/view")
    public String viewItemLog(Model model){
        return "admin/item_log";
    }

    @RequestMapping("/admindashboard/logs/inventorylog/view")
    public String viewInventoryLog(Model model){
        return "admin/inventory_log";
    }

    @RequestMapping("/admindashboard/logs/transactionlog/view")
    public String viewTransactionLog(Model model){
        return "admin/transaction_log";
    }












}
