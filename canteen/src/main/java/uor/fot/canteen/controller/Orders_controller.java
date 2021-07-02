package uor.fot.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import uor.fot.canteen.service.Orders_service;

@Controller
public class Orders_controller {

    @Autowired
    private Orders_service orders_service;
}
