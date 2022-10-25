package is.hi.hbv501g13.workouttracker.Controllers;


import is.hi.hbv501g13.workouttracker.Persistance.Entities.Exercise;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.User;
import is.hi.hbv501g13.workouttracker.Services.Implementations.ExerciseServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;



@Controller
public class ExerciseController {
    private ExerciseServiceImplementation exerciseService;

    @Autowired
    public ExerciseController(ExerciseServiceImplementation exerciseService) {
        this.exerciseService = exerciseService;
    }

    @RequestMapping(value = "/exercise", method = RequestMethod.GET)
    public String exerciseGET(Exercise exercise){
        return "exercise";
    }

    @RequestMapping(value = "/exercise", method = RequestMethod.POST)
    public String exercisePOST(Exercise exercise, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            return "redirect:/exercise";
        }
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if (sessionUser != null) {
            exercise.setUser(sessionUser);
            if (!exerciseService.checkExists(exercise.getName()) && exercise.getName().length() != 0) {
                exerciseService.save(exercise);
                System.out.println("Successsss");
                return "redirect:/exercise";
            }
        }

        return "redirect:/exercise";

    }


}
