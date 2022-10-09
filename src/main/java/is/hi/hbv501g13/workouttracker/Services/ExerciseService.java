package is.hi.hbv501g13.workouttracker.Services;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Exercise;

import java.util.ArrayList;

public interface ExerciseService {
    Exercise findByID(long ID);
    ArrayList<Exercise> findAll();
    Exercise findByName(String name);
    Exercise save(Exercise exercise);
    void delete(Exercise exercise);
}
