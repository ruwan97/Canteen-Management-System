package uor.fot.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import uor.fot.canteen.service.Transaction_service;

@Controller
public class Transaction_controller {

    @Autowired
    private Transaction_service transaction_service;
}
