package is.hi.hbv501g13.workouttracker.Services;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Workout;

import java.util.Date;
import java.util.List;

public interface WorkoutService {
    Workout findByID(long ID);
    List<Workout> findAll();
    Workout findByDate(Date date);
    Workout save(Workout workout);
    void delete(Workout workout);
}
