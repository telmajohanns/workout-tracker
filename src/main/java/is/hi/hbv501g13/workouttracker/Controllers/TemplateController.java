package is.hi.hbv501g13.workouttracker.Controllers;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Exercise;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.Template;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.User;
import is.hi.hbv501g13.workouttracker.Services.Implementations.ExerciseServiceImplementation;
import is.hi.hbv501g13.workouttracker.Services.Implementations.TemplateServiceImplementation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TemplateController {

    private TemplateServiceImplementation templateService;

    private ExerciseServiceImplementation exerciseService;
    private User user;
    private List<Exercise> templateExercises = new ArrayList<>();

    public TemplateController(TemplateServiceImplementation templateService,
                              ExerciseServiceImplementation exerciseService) {
        this.templateService = templateService;
        this.exerciseService = exerciseService;
    }


    @RequestMapping(value = "/template", method = RequestMethod.GET)
    public String templateGET(Template template, HttpSession session, Model model){
        user = (User) session.getAttribute("LoggedInUser");
        List<Exercise> exercises = exerciseService.findByUserID(user);
        model.addAttribute("exercises", exercises);
        System.out.println("template get methood");
        return "template";
    }

    @RequestMapping(value = "/template", method = RequestMethod.POST)
    public String templatePOST(Template template, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {return "redirect:/template";}
        user = (User) session.getAttribute("LoggedInUser");
        if (user != null) {
            template.setUser(user);

            if (!templateService.checkExists(template.getName()) && template.getName().length() != 0) {
                templateService.save(template);

                session.setAttribute("NewestTemplate", template);
                model.addAttribute("NewestTemplate", template);
                System.out.println("Successsss Template");
                return "redirect:/templateAddEx";
            }
        }
        return "redirect:/template";
    }

    @RequestMapping(value = "/templateAddEx", method = RequestMethod.GET)
    public String templateAddExGET(Exercise exercise, HttpSession session, Model model){
        user = (User) session.getAttribute("LoggedInUser");
        Template template = (Template) session.getAttribute("NewestTemplate");
        model.addAttribute("template", template);
        List<Exercise> exercises = exerciseService.findByUserID(user);
        model.addAttribute("exercises", exercises);
        System.out.println("Template add ex print");
        return "templateAddEx";
    }


    @RequestMapping(value = "/templateAddEx", method = RequestMethod.POST)
    public String templateAddExPOST(@RequestParam("exerciseName") String exerciseName, HttpSession session, Model model) {
        System.out.println(exerciseName);
        user = (User) session.getAttribute("LoggedInUser");
        Template sessionTemplate = (Template) session.getAttribute("NewestTemplate");
        model.addAttribute("template", sessionTemplate);
        templateExercises.add(exerciseService.findByName(exerciseName));

        List<Exercise> exercises = exerciseService.findByUserID(user);
        model.addAttribute("exercises", exercises);
        return "templateAddEx";
    }

    @RequestMapping(value="/templateCollection", method = RequestMethod.GET)
    public String templateCollectionGET(HttpSession session, Model model) {
        user = (User) session.getAttribute("LoggedInUser");
        Template sessionTemplate = (Template) session.getAttribute("NewestTemplate");

        sessionTemplate.setExercises(templateExercises);
        templateExercises.clear();
        templateService.save(sessionTemplate);
        List<Template> templates = templateService.findByUserID(user);
        model.addAttribute("templates", templates);
        System.out.println("Template collection print");
        session.removeAttribute("NewestTemplate");
        return "redirect:/collections";
    }

}
