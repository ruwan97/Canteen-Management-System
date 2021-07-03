package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uor.fot.canteen.model.Transaction;

public interface Transaction_repository extends JpaRepository<Transaction, Integer> {
}
