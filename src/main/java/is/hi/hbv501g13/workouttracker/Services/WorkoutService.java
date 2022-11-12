package is.hi.hbv501g13.workouttracker.Services;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.User;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.Workout;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public interface WorkoutService {
    Workout findByID(long ID);
    List<Workout> findAll();
    List<Workout> findByDate(LocalDate date);
    Workout save(Workout workout, User user);
    void delete(Workout workout);
}
