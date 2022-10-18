package is.hi.hbv501g13.workouttracker.Controllers;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Workout;
import is.hi.hbv501g13.workouttracker.Services.Implementations.WorkoutServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {
    private WorkoutServiceImplementation workoutService;

    @Autowired
    public HomeController(WorkoutServiceImplementation workoutService){
        this.workoutService = workoutService;
    }

    @RequestMapping("/")
    public String homePage(Model model){
        //Business logic
        //Call a method in a Service Class
        List<Workout> allWorkouts = workoutService.findAll();
        //Add some data to the Model
        model.addAttribute("workouts", allWorkouts);
        return "home";
    }

    @RequestMapping(value = "/addworkout", method = RequestMethod.GET)
    public String addWorkoutForm(Workout workout){

        return "newWorkout";
    }

    @RequestMapping(value="/addworkout", method = RequestMethod.POST)
    public String addWorkout(Workout workout, BindingResult result, Model model){
        if(result.hasErrors()){
            return "newWorkout";
        }
        workoutService.save(workout);
        return "redirect:/";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteWorkout(@PathVariable("id") long id, Model model){
        Workout workoutToDelete = workoutService.findByID(id);
        workoutService.delete(workoutToDelete);
        return "redirect:/";
    }
}
