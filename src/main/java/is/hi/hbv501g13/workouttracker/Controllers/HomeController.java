package is.hi.hbv501g13.workouttracker.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String HomeController(){ // Error: Method name 'HomeController' is the same as its class name. Rename this method to prevent any misunderstanding or make it a constructor.

        //Business logic
        //Call a method in a Service Class
        //Add some data to the Model
        return "home";
    }
}
