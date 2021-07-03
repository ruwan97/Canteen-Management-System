package uor.fot.canteen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/home/login/admindashboard")
    public String viewAdminDash(Model model){
        return "admin/admin_dashboard";
    }

    //user
    @RequestMapping("/home/login/admindashboard/user/view")
    public String viewUsers(Model model){
        return "admin/users";
    }

    @RequestMapping("/home/login/admindashboard/user/add")
    public String viewUserAdd(Model model){
        return "admin/user_add";
    }

    @RequestMapping("/home/login/admindashboard/user/update")
    public String viewUserUpdate(Model model){
        return "admin/user_update";
    }

    @RequestMapping("/home/login/admindashboard/user/updateform")
    public String viewUserUpdateForm(Model model){
        return "admin/user_update_form";
    }

    //item
    @RequestMapping("/home/login/admindashboard/items/view")
    public String viewItems(Model model){
        return "admin/items";
    }

    @RequestMapping("/home/login/admindashboard/item/add")
    public String viewItemAdd(Model model){
        return "admin/item_add";
    }

    @RequestMapping("/home/login/admindashboard/item/update")
    public String viewItemUpdate(Model model){
        return "admin/item_update";
    }

    @RequestMapping("/homelogin/admindashboard/item/updateform")
    public String viewItemUpdateForm(Model model){
        return "admin/item_update_form";
    }

    //inventory
    @RequestMapping("/home/login/admindashboard/inventory/view")
    public String viewInventory(Model model){
        return "admin/inventory";
    }

    @RequestMapping("/home/login/admindashboard/inventory/add")
    public String viewInventoryAdd(Model model){
        return "admin/inventory_add";
    }

    @RequestMapping("/login/admindashboard/inventory/update")
    public String viewInventoryUpdate(Model model){
        return "admin/inventory_update";
    }

    @RequestMapping("/home/login/admindashboard/inventory/updateform")
    public String viewInventoryUpdateForm(Model model){
        return "admin/inv_update_form";
    }

    //order
    @RequestMapping("/home/login/admindashboard/orders/view")
    public String viewOrders(Model model){
        return "admin/orders";
    }

    //transaction
    @RequestMapping("/home/login/admindashboard/transaction/view")
    public String viewTransactions(Model model){
        return "admin/transactions";
    }

    @RequestMapping("/home/login/admindashboard/transaction/viewsummary")
    public String viewTransactionsSummary(Model model){
        return "admin/transactions_summary";
    }

    //logs
    @RequestMapping("/home/login/admindashboard/logs/userlog/view")
    public String viewUserLog(Model model){
        return "admin/user_log";
    }

    @RequestMapping("/home/login/admindashboard/logs/oredrlog/view")
    public String viewOrderLog(Model model){
        return "admin/order_log";
    }

    @RequestMapping("/home/login/admindashboard/logs/itemlog/view")
    public String viewItemLog(Model model){
        return "admin/item_log";
    }

    @RequestMapping("/home/login/admindashboard/logs/inventorylog/view")
    public String viewInventoryLog(Model model){
        return "admin/inventory_log";
    }

    @RequestMapping("/home/login/admindashboard/logs/transactionlog/view")
    public String viewTransactionLog(Model model){
        return "admin/transaction_log";
    }














}
