package is.hi.hbv501g13.workouttracker.Controllers;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Exercise;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.Template;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.User;
import is.hi.hbv501g13.workouttracker.Services.Implementations.ExerciseServiceImplementation;
import is.hi.hbv501g13.workouttracker.Services.Implementations.TemplateServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class TemplateController {

    private TemplateServiceImplementation templateService;

    public TemplateController(TemplateServiceImplementation templateService) {
        this.templateService = templateService;
    }


    @RequestMapping(value = "/template", method = RequestMethod.GET)
    public String templateGET(Template template){
        return "template";
    }

    @RequestMapping(value = "/template", method = RequestMethod.POST)
    public String templatePOST(Template template, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {return "redirect:/template";}
        return "redirect:/template";
    }

}
