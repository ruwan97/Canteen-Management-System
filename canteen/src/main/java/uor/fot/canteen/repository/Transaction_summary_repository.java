package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uor.fot.canteen.model.Transactions_summary;

public interface Transaction_summary_repository extends JpaRepository<Transactions_summary, Integer> {
}
