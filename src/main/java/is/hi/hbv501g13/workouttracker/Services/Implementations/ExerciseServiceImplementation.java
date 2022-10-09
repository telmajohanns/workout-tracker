package is.hi.hbv501g13.workouttracker.Services.Implementations;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Exercise;
import is.hi.hbv501g13.workouttracker.Services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class ExerciseServiceImplementation implements ExerciseService {
    //Add link to JPA here
    private ArrayList<Exercise> exerciseRepo = new ArrayList<>();
    private long id_counter = 0;

    private ArrayList<Integer> set1 = new ArrayList<>(Arrays.asList(60, 8, 70, 8, 90, 4));
    private ArrayList<Integer> set2 = new ArrayList<>(Arrays.asList(60, 8, 70, 8, 90, 4));
    private ArrayList<Integer> set3 = new ArrayList<>(Arrays.asList(60, 8, 70, 8, 90, 4));
    @Autowired
    public ExerciseServiceImplementation(){
        exerciseRepo.add(new Exercise("user1", "bekkur", set1));
        exerciseRepo.add(new Exercise("user1", "squat", set2));
        exerciseRepo.add(new Exercise("user1", "dedd", set3));

        for (Exercise e:exerciseRepo) {
            e.setID(id_counter);
            id_counter++;
        }
    }

    @Override
    public Exercise findByID(long ID){
        for (Exercise e:exerciseRepo) {
            if (e.getID() == ID){
                return e;
            }
        }
        return null;
    }
    @Override
    public ArrayList<Exercise> findAll(){
        return exerciseRepo;
    }

    @Override
    public Exercise findByName(String name){
        for (Exercise e:exerciseRepo) {
            if (e.getName().equals(name)){
                return e;
            }
        }
        return null;
    }

    @Override
    public Exercise save(Exercise exercise){
        exercise.setID(id_counter);
        id_counter++;
        exerciseRepo.add(exercise);
        return exercise;
    }

    @Override
    public void delete(Exercise exercise){
        exerciseRepo.remove(exercise);
    }
}
