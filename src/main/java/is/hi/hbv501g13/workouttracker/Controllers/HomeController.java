package is.hi.hbv501g13.workouttracker.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @RequestMapping(value = "/")
    public String landingPage(){
        return "landingPage";
    }
}
