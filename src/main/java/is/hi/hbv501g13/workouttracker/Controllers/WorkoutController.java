package is.hi.hbv501g13.workouttracker.Controllers;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Exercise;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.Sett;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.User;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.Workout;
import is.hi.hbv501g13.workouttracker.Services.Implementations.WorkoutServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
public class WorkoutController {

    private WorkoutServiceImplementation workoutService;
    private List<Sett> sets;
    private User user;
    private LocalDate date = LocalDate.now();

    @Autowired
    public WorkoutController(WorkoutServiceImplementation workoutService){
        this.workoutService = workoutService;
    }

    @RequestMapping(value = "/workout", method = RequestMethod.GET)
    public String workoutGET(Workout workout, HttpSession session){
        user = (User) session.getAttribute("LoggedInUser");
        return "newWorkout";
    }

    @RequestMapping(value = "/workout", method = RequestMethod.POST)
    public String workoutPOST(Workout workout, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            return "redirect:/workout"; //returns to an empty workout
            //TODO fix it so it stores the date and returns you to the page with your data.
        }

        if (user != null){
            workout.setDate(date);
            workout.setUserID(user);
            workout.setSets(sets);

        }
        return "/homePage";
    }



}
