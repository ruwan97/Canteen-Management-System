package uor.fot.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import uor.fot.canteen.service.Transaction_log_service;

@Controller
public class Transaction_log_controller {

    @Autowired
    private Transaction_log_service transaction_log_service;
}
