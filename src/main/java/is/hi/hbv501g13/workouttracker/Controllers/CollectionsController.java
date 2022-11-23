package is.hi.hbv501g13.workouttracker.Controllers;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Exercise;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.Template;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.User;
import is.hi.hbv501g13.workouttracker.Services.Implementations.ExerciseServiceImplementation;
import is.hi.hbv501g13.workouttracker.Services.Implementations.TemplateServiceImplementation;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CollectionsController {
    private TemplateServiceImplementation templateService;
    private ExerciseServiceImplementation exerciseService;
    private User user;

    public CollectionsController(TemplateServiceImplementation templateService,
                                 ExerciseServiceImplementation exerciseService) {
        this.templateService = templateService;
        this.exerciseService = exerciseService;
    }
    @RequestMapping(value="/collections", method = RequestMethod.GET)
    public String collectionsGET(HttpSession session, Model model) {
        user = (User) session.getAttribute("LoggedInUser");
        System.out.println("User: " + user.getID());
        List<Exercise> exercises = exerciseService.findByUserID(user);
        //session.setAttribute("exercises", exercises);
        model.addAttribute("exercises", exercises);
        List<Template> templates = templateService.findByUserID(user);
        //session.setAttribute("templates",templates);
        model.addAttribute("templates", templates);
        return "collections";
    }
}
