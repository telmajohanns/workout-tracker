package is.hi.hbv501g13.workouttracker;
// This is team member Steinunn María Egilsdóttir - updated git config settings
// This is team member Jón Jónsson
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "is.hi.hbv501g13.workouttracker.Persistance.Repositories"})
public class WorkoutTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkoutTrackerApplication.class, args);
    }

}
