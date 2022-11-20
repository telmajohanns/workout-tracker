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

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TemplateController {

    private TemplateServiceImplementation templateService;

    private ExerciseServiceImplementation exerciseService;
    private User user;

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
            //template.setExercises(template.getExercises().add(Model.getAttribute()));
            //model.addAttribute("exerciseList", template.getExercises());

            if (!templateService.checkExists(template.getName()) && template.getName().length() != 0) {
                templateService.save(template);
                session.setAttribute("NewestTemplate", template);
                model.addAttribute("NewestTemplate", template);
                System.out.println("Successsss Template");
                return "templateAddEx";
            }
        }
        return "redirect:/template";
    }

    //VIRKAR EKKI RÉTT
    //Þurfum að ná að sækja exercises sem eru til á LoggedInUser og bæta þeim í dropdown boxið sem options
    /*@RequestMapping(value = "/templateAddEx", method = RequestMethod.GET)
    public String templateAddExGET(Template template, HttpSession session, Model model){
        //User sessionUser = (User) session.getAttribute("LoggedInUser");
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        List<Exercise> exercises = exerciseService.findAll();
        model.addAttribute("exercises", exercises);
        //sessionUser.getExercises();
        return "templateAddEx";
    }*/
    @RequestMapping(value = "/templateAddEx", method = RequestMethod.GET)
    public String templateAddExGET(Exercise exercise, HttpSession session, Model model){
        List<Exercise> exercises = exerciseService.findAll();
        model.addAttribute("exercises", exercises);
        return "templateAddEx";
    }

    //VIRKAR EKKI RÉTT
    //Þurfum að ná að bæta við völdu exercise á lista af exercises í template-inu þegar ýtt á "Add exercise"
    @RequestMapping(value = "/templateAddEx", method = RequestMethod.POST)
    public String templateAddExPOST(@ModelAttribute("templateAddEx") Exercise exercise, Model model) {
        Template sessionTemplate = (Template) model.getAttribute("NewestTemplate");
        sessionTemplate.addExercise(exercise);
        return "templateAddEx";
    }
    /*
    public String templateAddExPOST(Template template, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {return "redirect:/templateAddEx";}

        //User sessionUser = (User) session.getAttribute("LoggedInUser");
        /*Template sessionTemplate = (Template) session.getAttribute("NewestTemplate");
        if (sessionTemplate != null) {
            session.setAttribute("ChosenExercise", exercise);
            model.addAttribute("ChosenExercise", exercise);
            sessionTemplate.addExercise((Exercise) model.getAttribute("ChosenExercise"));
            System.out.println(sessionTemplate.getExercises().get(0).getName());
            //sessionTemplate.addExercise(exercise);
            //sessionTemplate.addExercise((Exercise)model.getAttribute(String.valueOf(exercise)));

            //System.out.println(model.getAttribute(String.valueOf(exercise)));
            //System.out.println("Successsss add " + sessionTemplate.getExercises().get(0).getName());
            //System.out.println("EX " + exercise.getName());
            return "redirect:/templateAddEx";

            //TODO bæta exercises with model eða einhverstaðar sem við getum náð í þær
            //og bætt þeim á listann.
            //template.setExercises(template.getExercises().add(Model.getAttribute()));
            //model.addAttribute("exerciseList", template.getExercises());
        }*/
       /* return "redirect:/templateAddEx";
    }*/
}
