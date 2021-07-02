package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uor.fot.canteen.model.User;

public interface User_repository extends JpaRepository<User, String> {
}
