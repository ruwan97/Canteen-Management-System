package uor.fot.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import uor.fot.canteen.service.Item_log_service;

@Controller
public class Item_log_controller {

    @Autowired
    private Item_log_service item_log_service;
}
