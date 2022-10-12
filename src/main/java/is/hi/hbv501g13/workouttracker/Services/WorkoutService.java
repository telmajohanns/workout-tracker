package is.hi.hbv501g13.workouttracker.Services;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Workout;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface WorkoutService {
    Workout findByID(long ID);
    List<Workout> findAll();
    List<Workout> findByDate(LocalDate date);
    Workout save(Workout workout);
    void delete(Workout workout);
}
