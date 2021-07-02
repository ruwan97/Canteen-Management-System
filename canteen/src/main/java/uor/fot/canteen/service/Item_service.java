package uor.fot.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uor.fot.canteen.repository.Item_repository;

import javax.transaction.Transactional;

@Service
@Transactional
public class Item_service {

    @Autowired
    private Item_repository item_repository;
}
