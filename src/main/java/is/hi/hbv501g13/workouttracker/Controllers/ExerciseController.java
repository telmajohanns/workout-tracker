package is.hi.hbv501g13.workouttracker.Controllers;


import is.hi.hbv501g13.workouttracker.Persistance.Entities.Exercise;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.User;
import is.hi.hbv501g13.workouttracker.Services.Implementations.ExerciseServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class ExerciseController {
    private ExerciseServiceImplementation exerciseService;

    @Autowired
    public ExerciseController(ExerciseServiceImplementation exerciseService) {
        this.exerciseService = exerciseService;
    }


    @RequestMapping(value="/exerciseCollection")
    public String exerciseCollection(Model model, HttpSession session){
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        //Call a method in a Service Class
        List<Exercise> allExercises = exerciseService.findByUserID(sessionUser.getID());
        //Add some data to the Model
        model.addAttribute("exercises", allExercises);
        return "exerciseCollection";
    }

    @RequestMapping(value = "/exercise", method = RequestMethod.GET)
    public String exerciseGET(Exercise exercise){
        return "exercise";
    }

    @RequestMapping(value="/exerciseCollection", method = RequestMethod.GET)
    public String exerciseCollectionGET(Exercise exercise) {
        return "exerciseCollection";
    }

    @RequestMapping(value = "/exerciseCollection", method = RequestMethod.POST)
    public String exerciseCollectionPOST(Exercise exercise,  BindingResult result, Model model) {
        if(result.hasErrors()) {return "redirect:/homePage";}
        return "exercise";
    }


    @RequestMapping(value = "/exercise", method = RequestMethod.POST)
    public String exercisePOST(Exercise exercise, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            return "exercise";
        }
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if (sessionUser != null) {
            exercise.setUser(sessionUser);
            if (!exerciseService.checkExists(exercise.getName()) && exercise.getName().length() != 0) {
                exerciseService.save(exercise);
                System.out.println("Successsss");
                return "redirect:/exerciseCollection";
            }
        }

        return "redirect:/exerciseCollection";

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteExercise(@PathVariable("id") long id, Model model) {
        Exercise exerciseToDelete = exerciseService.findByID(id);
        exerciseService.delete(exerciseToDelete);
        return "redirect:/exercise";
    }

}
