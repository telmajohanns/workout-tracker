package is.hi.hbv501g13.workouttracker.Controllers;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.*;
import is.hi.hbv501g13.workouttracker.Services.Implementations.ExerciseServiceImplementation;
import is.hi.hbv501g13.workouttracker.Services.Implementations.SettServiceImplementation;
import is.hi.hbv501g13.workouttracker.Services.Implementations.TemplateServiceImplementation;
import is.hi.hbv501g13.workouttracker.Services.Implementations.WorkoutServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WorkoutController {

    private WorkoutServiceImplementation workoutService;
    private SettServiceImplementation settService;
    private TemplateServiceImplementation templateService;
    private ExerciseServiceImplementation exerciseService;
    private List<Sett> sets;
    private User user;
    private LocalDate date = LocalDate.now();

    @Autowired
    public WorkoutController(WorkoutServiceImplementation workoutService, SettServiceImplementation settService,
                             TemplateServiceImplementation templateService, ExerciseServiceImplementation exerciseService){
        this.workoutService = workoutService;
        this.settService = settService;
        this.templateService = templateService;
        this.exerciseService = exerciseService;
    }

    @RequestMapping(value = "/workout", method = RequestMethod.GET)
    public String workoutGET(Workout workout, HttpSession session, Model model){
        user = (User) session.getAttribute("LoggedInUser");
        List<Template> templates = templateService.findAll();
        model.addAttribute("templates", templates);
        return "newWorkout";
    }


    @RequestMapping(value = "/workout", method = RequestMethod.POST)
    public String workoutPOST(Workout workout, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            return "redirect:/workout"; //returns to an empty workout
            //TODO fix it so it stores the date and returns you to the page with your data.
        }
        user = (User) session.getAttribute("LoggedInUser");
        workoutService.save(workout, user);
        model.addAttribute("workout", workout);
        return "redirect:/currentWorkout";
    }

    @RequestMapping(value = "/currentWorkout", method = RequestMethod.GET)
    public String currentWorkoutGET(Workout workout, BindingResult result, Model model, HttpSession session){
        user = (User) session.getAttribute("LoggedInUser");
        List<Exercise> exercises = exerciseService.findAll();
        model.addAttribute("exercises", exercises);

        return "currentWorkout";
    }


}
