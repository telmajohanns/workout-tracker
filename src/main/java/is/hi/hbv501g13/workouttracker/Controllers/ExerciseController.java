package is.hi.hbv501g13.workouttracker.Controllers;


import is.hi.hbv501g13.workouttracker.Persistance.Entities.Exercise;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.User;
import is.hi.hbv501g13.workouttracker.Services.Implementations.ExerciseServiceImplementation;
import is.hi.hbv501g13.workouttracker.Services.Implementations.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.awt.event.ActionEvent;


@Controller
public class ExerciseController {

    private ExerciseServiceImplementation exerciseService;
    // Vantar að fá hvaða user er loggaður inn??
    private Long userID;
    private User user;
    //private UserServiceImplementation userService;
    private Exercise exercise;

    @Autowired
    public ExerciseController(ExerciseServiceImplementation exerciseService) {
        this.exerciseService = exerciseService;
    }

    /**
     * Save exercise to users collection
     * @param actionEvent User presses "save" button
     */
    public void saveExercise(ActionEvent actionEvent) {
        if (!exerciseService.checkExists("dummy exercise")) {
            exercise = new Exercise(user, "dummy exercise");
            exerciseService.save(exercise);
        }
        else {
            System.out.println("ERROR: Exercise exists in database");
        }
    }

    @RequestMapping(value = "/exercise", method = RequestMethod.GET)
    public String exerciseGET(Exercise exercise){
        return "exercise";
    }

   /* @RequestMapping(value = "/exercise", method = RequestMethod.POST)
    public String exercisePOST(BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            return "exercise";
        }
        Exercise exists = exerciseService.findByID(exercise.getID());
        if (exists != null) {
            session.setAttribute("ExerciseCreated", exercise);
            model.addAttribute("ExerciseCreated", exercise);
            return "ExerciseCreated";
        }
        return  "redirect:/";
    }*/


}
