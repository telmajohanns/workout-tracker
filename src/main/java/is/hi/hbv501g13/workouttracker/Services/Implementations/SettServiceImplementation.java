package is.hi.hbv501g13.workouttracker.Services.Implementations;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Exercise;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.Sett;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.Workout;
import is.hi.hbv501g13.workouttracker.Persistance.Repositories.SettRepository;
import is.hi.hbv501g13.workouttracker.Services.SettService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettServiceImplementation implements SettService {

    private SettRepository settRepository;

    @Autowired
    public SettServiceImplementation(SettRepository settRepository){
        this.settRepository = settRepository;
    }

    @Override
    public Sett save(Sett sett, Workout workout, Exercise exercise) {

        sett.setExercise(exercise);
        long id = workout.getID();
        System.out.println("workout id is: " + id);
        sett.setWorkout(workout);

        return settRepository.save(sett);
    }

    @Override
    public void delete(Sett sett) {
        settRepository.delete(sett);
    }

    @Override
    public List<Sett> findAll() {
        return settRepository.findAll();
    }

    @Override
    public List<Sett> findByWorkout(Workout workout) {
        return settRepository.findByWorkout(workout);
    }

    @Override
    public List<Sett> findByExercise(Exercise exercise) {
        return settRepository.findByExercise(exercise);
    }
}
