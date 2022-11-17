package is.hi.hbv501g13.workouttracker.Services;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Exercise;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.Sett;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.Workout;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SettService {
    Sett save(Sett sett, Workout workout, Exercise exercise);
    void delete(Sett sett);
    List<Sett> findAll();
    List<Sett> findByWorkout(Workout workout);
    List<Sett> findByExercise(Exercise exercise);
}
