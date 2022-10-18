package is.hi.hbv501g13.workouttracker.Persistance.Repositories;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {



    Workout save(Workout workout);
    void delete(Workout workout);

    List<Workout> findAll();
    List<Workout> findByDate(LocalDate date);
    Workout findByID(long id);
}
