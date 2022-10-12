package is.hi.hbv501g13.workouttracker.Services;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Exercise;

import java.util.ArrayList;
import java.util.List;

public interface ExerciseService {
    Exercise findByID(long ID);
    List<Exercise> findAll();
    Exercise findByName(String name);
    Exercise save(Exercise exercise);
    void delete(Exercise exercise);
}
