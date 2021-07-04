package uor.fot.canteen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/admindashboard")
    public String viewAdminDash(Model model){
        return "admin/admin_dashboard";
    }

    //user
    @RequestMapping("/admindashboard/user/view")
    public String viewUsers(Model model){
        return "admin/users";
    }

    @RequestMapping("/admindashboard/user/add")
    public String viewUserAdd(Model model){
        return "admin/user_add";
    }

    @RequestMapping("/admindashboard/user/update")
    public String viewUserUpdate(Model model){
        return "admin/user_update";
    }

    @RequestMapping("/admindashboard/user/updateform")
    public String viewUserUpdateForm(Model model){
        return "admin/user_update_form";
    }

    //item
    @RequestMapping("/admindashboard/items/view")
    public String viewItems(Model model){
        return "admin/items";
    }

    @RequestMapping("/admindashboard/item/add")
    public String viewItemAdd(Model model){
        return "admin/item_add";
    }

    @RequestMapping("/admindashboard/item/update")
    public String viewItemUpdate(Model model){
        return "admin/item_update";
    }

    @RequestMapping("/admindashboard/item/updateform")
    public String viewItemUpdateForm(Model model){
        return "admin/item_update_form";
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
