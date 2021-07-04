package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uor.fot.canteen.model.Item;

public interface Item_repository extends JpaRepository<Item, String> {
}
