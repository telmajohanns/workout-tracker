package is.hi.hbv501g13.workouttracker.Services.Implementations;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Exercise;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.Workout;
import is.hi.hbv501g13.workouttracker.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class WorkoutServiceImpementation implements WorkoutService {
    //Add link to JPA here
    private ArrayList<Workout> workoutRepository = new ArrayList<>();
    private long id_counter = 0;

    private ArrayList<Exercise> exercises2 = new ArrayList<>(Arrays.asList(new Exercise()));
    @Autowired
    public WorkoutServiceImpementation() {
        //Create a random workout for our repository, removed when we get a DB
        workoutRepository.add(new Workout(java.time.LocalDate.now(), exercises2));
        workoutRepository.add(new Workout(java.time.LocalDate.now(), exercises2));
        workoutRepository.add(new Workout(java.time.LocalDate.now(), exercises2));

        for (Workout w:workoutRepository) {
            w.setID(id_counter);
            id_counter++;
        }
    }


    @Override
    public Workout findByID(long ID) {
        for (Workout w:workoutRepository) {
            if(w.getID() == ID){
                return w;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Workout> findAll() {
        return workoutRepository;
    }

    @Override
    public Workout findByDate(LocalDate date) {
        for (Workout w:workoutRepository) {
            if (w.getDate() == date){
                return w;
            }
        }
        return null;
    }

    @Override
    public Workout save(Workout workout) {
        workout.setID(id_counter);
        id_counter++;
        workoutRepository.add(workout);
        return workout;
    }

    @Override
    public void delete(Workout workout) {
        workoutRepository.remove(workout);
    }
}
