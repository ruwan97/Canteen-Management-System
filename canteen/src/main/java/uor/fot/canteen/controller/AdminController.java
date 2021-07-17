package uor.fot.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import uor.fot.canteen.model.*;
import uor.fot.canteen.service.*;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private User_service user_service;
    @Autowired
    private Item_service item_service;
    @Autowired
    private Orders_service orders_service;
    @Autowired
    private Transaction_service transaction_service;
    @Autowired
    private Transactions_summary_service transactions_summary_service;
    @Autowired
    private Inventory_service inventory_service;
    @Autowired
    private User_log_service user_log_service;
    @Autowired
    private Order_log_service order_log_service;
    @Autowired
    private Item_log_service item_log_service;
    @Autowired
    private Inventory_log_service inventory_log_service;
    @Autowired
    private Transaction_log_service transaction_log_service;


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

    //view add user page
    @RequestMapping("/admindashboard/user/add")
    public String viewAddUserPage(Model model){
        return "admin/user_add";
    }

    //admin add user
    @PostMapping("/adduser")
    public String addUser(@RequestParam("id") String u_id, @RequestParam("name") String u_name, @RequestParam("email") String u_email, @RequestParam("password") String u_password, @RequestParam("role") Integer u_role, @RequestParam("contact") String u_contact, @RequestParam("image") MultipartFile u_image)
    {
        user_service.registerUser(u_id, u_name, u_email,u_password, u_role, u_contact, u_image);

        return "redirect:/admindashboard/user/view";

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
    public String adUpdateUsers(@RequestParam("id") String u_id, @RequestParam("name") String u_name, @RequestParam("email") String u_email, @RequestParam("password") String u_password, @RequestParam("role") Integer u_role, @RequestParam("contact") Integer u_contact, @RequestParam("image") MultipartFile u_image){
        user_service.userUpdate(u_id, u_name, u_email, u_password, u_role, u_contact, u_image);
        return "redirect:/admindashboard/user/view";
    }



    //view add item page
    @RequestMapping("/admindashboard/item/add")
    public String viewAddItemPage(Model model){
        return "admin/item_add";
    }

    //admin add item
    @RequestMapping("/additem")
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

    //admin update item
    @PostMapping("/itemupdate")
    public String adUdpdateItems(@RequestParam("id") String item_id, @RequestParam("name") String item_name, @RequestParam("price") Float unit_price, @RequestParam("image") String item_image){
        item_service.adItemUpdate(item_id, item_name, unit_price, item_image);
        return "redirect:/admindashboard/items/view";
    }

    //admin delete item
    @RequestMapping("/admindashboard/item/delete/{id}")
    public String deleteItem(@PathVariable("id") String item_id){
        boolean result = item_service.deleteItem(item_id);
        if (result)
            return "redirect:/admindashboard/items/view";
        else
            return "redirect:/admindashboard/items/view";
    }


    //inventory
    //view add inventory page
    @RequestMapping("/admindashboard/inventory/add")
    public String viewInventoryAdd(Model model){
        return "admin/inventory_add";
    }
    //admin add inventory
    @RequestMapping("/addinventory")
    public String addInventory(@RequestParam("id") String item_id, @RequestParam("quantity") Integer quantity)
    {
        boolean result = inventory_service.addInventory(item_id, quantity);
        if (result)
            return "redirect:/admindashboard/inventory/view";
        else
            return "redirect:/admindashboard/inventory/add";
    }

    //admin view inventory
    @RequestMapping("/admindashboard/inventory/view")
    public String viewInventory(Model model){
            List<Inventory> inventories = inventory_service.getAllInventoryItems();
//        List<Inventory> inventories = inventory_service.getAllInventoryItems();
            model.addAttribute("viewinventory", inventories);
//        model.addAttribute("viewitems", inventories);

            return "admin/inventory";
    }

    //admin inventory update view
    @RequestMapping("/admindashboard/inventory/update")
    public String viewUpdateInventory(Model model){
        List<Inventory> inventories = inventory_service.getAllInventoryItems();
        model.addAttribute("viewinventory", inventories);
        return "admin/inventory_update";
    }

    //admin inventory update form
    @RequestMapping("/admindashboard/inventory/updateform/{id}")
    public String viewInventoryUpdateForm(Model model, @PathVariable("id") Integer id){
        Inventory inventory = inventory_service.getItem(id);
        model.addAttribute("updateinventory", inventory);
        return "admin/inv_update_form";
    }

    //admin update inventory
    @PostMapping("/inventoryupdate")
    public String adUdpdateInventory(@RequestParam("id") Integer inv_id, @RequestParam("itemId") String item_id, @RequestParam("quantity") Integer quantity){
        inventory_service.adInventoryUpdate(inv_id, item_id, quantity);
        return "redirect:/admindashboard/inventory/view";
    }

    //admin delete inventory
    @RequestMapping("/admindashboard/inventory/delete/{id}")
    public String deleteInventory(@PathVariable("id") String item_id){
        boolean result = inventory_service.deleteInventory(item_id);
        if (result)
            return "redirect:/admindashboard/inventory/view";
        else
            return "redirect:/admindashboard/inventory/view";
    }


    //admin view orders
    @RequestMapping("/admindashboard/orders/view")
    public String viewOrders(Model model){
        List<Orders> orders = orders_service.getAllOrders();
//        List<Inventory> inventories = inventory_service.getAllInventoryItems();
        model.addAttribute("vieworders", orders);
//        model.addAttribute("viewitems", inventories);
        return "admin/orders";
    }

    //admin confirm order
    @RequestMapping("/admindashboard/order/confirm/{id}")
    public String confirmOrder(@PathVariable("id") Integer order_id){
        boolean result = transaction_service.confirmOrder(order_id);
        if (result)
            return "redirect:/admindashboard/transaction/view";
        else
            return "redirect:/admindashboard/orders/view";
    }


    //admin view transactions
    @RequestMapping("/admindashboard/transaction/view")
    public String viewTransactions(Model model){
        List<Transaction> transactions = transaction_service.getAllTransactions();
        model.addAttribute("viewtransactions", transactions);
        return "admin/transactions";
    }

    @RequestMapping("/admindashboard/transaction/viewsummary")
    public String viewTransactionsSummary(Model model){
        List<Transactions_summary> transactions_summaries = transactions_summary_service.getDailyTransactions();
        model.addAttribute("viewtransactionSummaries", transactions_summaries);
        return "admin/transactions_summary";
    }

    //view user log
    @RequestMapping("/admindashboard/logs/userlog/view")
    public String viewUserLog(Model model){
        List<User_log> user_logs = user_log_service.getUserLog();
        model.addAttribute("viewuserlog", user_logs);
        return "admin/user_log";
    }

    //view order log
    @RequestMapping("/admindashboard/logs/oredrlog/view")
    public String viewOrderLog(Model model){
        List<Order_log> order_logs = order_log_service.getOrderLog();
        model.addAttribute("vieworderlog", order_logs);
        return "admin/order_log";
    }

    //view item log
    @RequestMapping("/admindashboard/logs/itemlog/view")
    public String viewItemLog(Model model){
        List<Item_log> item_logs = item_log_service.getItemLog();
        model.addAttribute("viewitemlog", item_logs);
        return "admin/item_log";
    }


    //view inventory log
    @RequestMapping("/admindashboard/logs/inventorylog/view")
    public String viewInventoryLog(Model model){
        List<Inventory_log> inventory_logs = inventory_log_service.getInventoryLog();
        model.addAttribute("viewinventorylog", inventory_logs);
        return "admin/inventory_log";
    }

    //view transaction log
    @RequestMapping("/admindashboard/logs/transactionlog/view")
    public String viewTransactionLog(Model model){
        List<Transaction_log> transaction_logs = transaction_log_service.getTransactionLog();
        model.addAttribute("viewtransactionlog", transaction_logs);
        return "admin/transaction_log";
    }










}
