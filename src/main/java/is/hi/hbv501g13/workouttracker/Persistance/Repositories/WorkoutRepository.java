package is.hi.hbv501g13.workouttracker.Persistance.Repositories;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    Workout save(Workout workout);
    void delete(Workout workout);

    List<Workout> findAll();
    List<Workout> findByDate(LocalDate date);
    Workout findByID(long id);
}
