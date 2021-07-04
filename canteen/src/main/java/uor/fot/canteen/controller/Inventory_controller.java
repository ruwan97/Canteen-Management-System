package uor.fot.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import uor.fot.canteen.service.Inventory_service;

@Controller
public class Inventory_controller {

    @Autowired
    private Inventory_service inventory_service;
}
