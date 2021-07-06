package uor.fot.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uor.fot.canteen.model.User;
import uor.fot.canteen.model.User_log;

import java.util.List;

@Repository
public interface User_log_repository extends JpaRepository<User_log, Integer> {

    //view user log
    @Query(value = "SELECT *FROM user_log", nativeQuery = true)
    List<User_log> getUserLog();
}
