package uor.fot.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import uor.fot.canteen.service.Order_log_service;

@Controller
public class Order_log_controller {

    @Autowired
    private Order_log_service order_log_service;
}
