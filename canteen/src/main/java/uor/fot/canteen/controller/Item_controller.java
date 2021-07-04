package uor.fot.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import uor.fot.canteen.service.Item_service;

@Controller
public class Item_controller {

    @Autowired
    private Item_service item_service;
}
