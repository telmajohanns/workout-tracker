package is.hi.hbv501g13.workouttracker.Controllers;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Exercise;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.Template;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.User;
import is.hi.hbv501g13.workouttracker.Services.Implementations.TemplateServiceImplementation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TemplateController {

    private TemplateServiceImplementation templateService;
    private List<Exercise> exercises = new ArrayList<Exercise>();

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
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if (sessionUser != null) {
            template.setUser(sessionUser);

            //TODO bæta exercises with model eða einhverstaðar sem við getum náð í þær
            //og bætt þeim á listann.
            //template.setExercises(template.getExercises().add(Model.getAttribut(e)));
            //model.addAttribute("exerciseList", template.getExercises());

            if (!templateService.checkExists(template.getName()) && template.getName().length() != 0) {
                templateService.save(template);
                System.out.println("Successsss Template");
                return "redirect:/template";
            }
        }
        return "redirect:/template";
    }

}
