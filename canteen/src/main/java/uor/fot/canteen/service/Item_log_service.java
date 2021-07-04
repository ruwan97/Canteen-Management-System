package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uor.fot.canteen.repository.Item_log_repository;

import javax.transaction.Transactional;

@Service
@Transactional
public class Item_log_service {

    @Autowired
    private Item_log_repository item_log_repository;
}
