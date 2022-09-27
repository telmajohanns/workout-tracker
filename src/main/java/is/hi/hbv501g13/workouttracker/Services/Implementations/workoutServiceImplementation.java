package is.hi.hbv501g13.workouttracker.Services.Implementations;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Workout;
import is.hi.hbv501g13.workouttracker.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class workoutServiceImplementation implements WorkoutService {
    private List<Workout> workoutRepository = new ArrayList<>();
    private int id_counter = 0;

    @Autowired
    public workoutServiceImplementation() {
        //Create a random workout for our repository, removed when we get a DB
    }

    @Override
    public Workout findByID(long ID) {
        return null;
    }

    @Override
    public List<Workout> findAll() {
        return null;
    }

    @Override
    public Workout findByDate(Date date) {
        return null;
    }

    @Override
    public Workout save(Workout workout) {
        return null;
    }

    @Override
    public void delete(Workout workout) {

    }
}
