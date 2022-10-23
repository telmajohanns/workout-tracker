package is.hi.hbv501g13.workouttracker.Controllers;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.User;
import is.hi.hbv501g13.workouttracker.Services.Implementations.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired  //This is just to have dummy data to work with
    private UserServiceImplementation userService;



    @RequestMapping(value = "/")
    public String landingPage(){
        User v = new User("admin", "admin"); //Dummy user, remove later
        userService.save(v);
        return "redirect:/login";
    }

    @RequestMapping(value = "/homepage")
    public String homePage(){
        return "/homePage";
    }
}
