package is.hi.hbv501g13.workouttracker.Services;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User save(User user);
    void delete(User user);
    User findByUsername(String username);
    User login(User user);
}
