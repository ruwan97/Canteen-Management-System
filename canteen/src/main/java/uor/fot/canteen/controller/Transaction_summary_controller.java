package uor.fot.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import uor.fot.canteen.service.Transactions_summary_service;

@Controller
public class Transaction_summary_controller {

    @Autowired
    private Transactions_summary_service transactions_summary_service;
}
