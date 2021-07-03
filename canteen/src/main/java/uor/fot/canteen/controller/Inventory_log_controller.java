package uor.fot.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import uor.fot.canteen.service.Inventory_log_service;

@Controller
public class Inventory_log_controller {

    @Autowired
    private Inventory_log_service inventory_log_service;
}
