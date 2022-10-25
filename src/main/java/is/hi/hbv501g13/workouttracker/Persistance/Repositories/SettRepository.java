package is.hi.hbv501g13.workouttracker.Persistance.Repositories;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Exercise;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.Sett;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettRepository extends JpaRepository<Sett, Long> {

    Sett save(Sett sett);
    void delete(Sett sett);
    List<Sett> findAll();
    List<Sett> findByWorkout(Workout workout);
    List<Sett> findByExercise(Exercise exercise);
}
