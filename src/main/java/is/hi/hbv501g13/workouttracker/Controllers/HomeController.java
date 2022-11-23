package is.hi.hbv501g13.workouttracker.Controllers;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Exercise;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.Template;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.User;
import is.hi.hbv501g13.workouttracker.Services.Implementations.ExerciseServiceImplementation;
import is.hi.hbv501g13.workouttracker.Services.Implementations.TemplateServiceImplementation;
import is.hi.hbv501g13.workouttracker.Services.Implementations.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired  //This is just to have dummy data to work with
    private UserServiceImplementation userService;
    @Autowired
    private TemplateServiceImplementation templateService;
    @Autowired
    private ExerciseServiceImplementation exerciseService;


    @RequestMapping(value = "/")
    public String landingPage(){
        if(userService.findByUsername("admin") == null) {
            User v = new User("admin", "admin"); //Dummy user, remove later
            userService.save(v);
            //List<Exercise> ex = new ArrayList<>();
            //Template t1 = new Template("chest", v, ex);
            //Template t2 = new Template("legs", v, ex);
            //templateService.save(t1);
            //templateService.save(t2);
            //Exercise exercise = new Exercise(v, "bekkur");

        }
        return "redirect:login";
    }

    @RequestMapping(value = "/homepage")
    public String homePage(){
        return "homePage";
    }
}
