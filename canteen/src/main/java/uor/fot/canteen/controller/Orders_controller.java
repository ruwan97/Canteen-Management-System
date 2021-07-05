package uor.fot.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import uor.fot.canteen.model.Orders;
import uor.fot.canteen.model.User;
import uor.fot.canteen.service.Orders_service;
import uor.fot.canteen.service.User_service;

import java.nio.file.Path;

@Controller
public class Orders_controller {

    @Autowired
    private Orders_service orders_service;


}
