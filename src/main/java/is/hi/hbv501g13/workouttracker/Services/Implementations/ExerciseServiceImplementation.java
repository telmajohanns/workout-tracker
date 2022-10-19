package is.hi.hbv501g13.workouttracker.Services.Implementations;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Exercise;
import is.hi.hbv501g13.workouttracker.Persistance.Repositories.ExerciseRepository;
import is.hi.hbv501g13.workouttracker.Services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImplementation implements ExerciseService {
    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseServiceImplementation(ExerciseRepository exerciseRepository){
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Exercise findByID(long ID){
        return exerciseRepository.findByID(ID);
    }
    @Override
    public List<Exercise> findAll(){
        return exerciseRepository.findAll();
    }

    @Override
    public Exercise findByName(String name){
        return exerciseRepository.findByName(name);
    }

    @Override
    public Exercise save(Exercise exercise){
        return exerciseRepository.save(exercise);
    }

    @Override
    public void delete(Exercise exercise){
        exerciseRepository.delete(exercise);
    }
}
