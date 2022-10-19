package is.hi.hbv501g13.workouttracker.Services.Implementations;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Workout;
import is.hi.hbv501g13.workouttracker.Persistance.Repositories.WorkoutRepository;
import is.hi.hbv501g13.workouttracker.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WorkoutServiceImplementation implements WorkoutService {


    private WorkoutRepository workoutRepository;


    @Autowired
    public WorkoutServiceImplementation(WorkoutRepository workoutRepository) {
       this.workoutRepository = workoutRepository;
    }


    @Override
    public Workout findByID(long ID) {
        return workoutRepository.findByID(ID);
    }

    @Override
    public List<Workout> findAll() {
        return workoutRepository.findAll();
    }

    @Override
    public List<Workout> findByDate(LocalDate date) {
        return workoutRepository.findByDate(date);
    }

    @Override
    public Workout save(Workout workout) {
        return workoutRepository.save(workout);
    }

    @Override
    public void delete(Workout workout) {
        workoutRepository.delete(workout);
    }
}
