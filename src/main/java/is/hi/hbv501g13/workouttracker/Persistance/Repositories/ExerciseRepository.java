package is.hi.hbv501g13.workouttracker.Persistance.Repositories;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    Exercise save(Exercise exercise);
    void delete(Exercise exercise);

    List<Exercise> findAll();
    Exercise findByID(long id);
    Exercise findByName(String name);
}
