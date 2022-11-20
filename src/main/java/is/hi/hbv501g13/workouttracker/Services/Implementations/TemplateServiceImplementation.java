package is.hi.hbv501g13.workouttracker.Services.Implementations;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Template;
import is.hi.hbv501g13.workouttracker.Persistance.Entities.User;
import is.hi.hbv501g13.workouttracker.Persistance.Repositories.TemplateRepository;
import is.hi.hbv501g13.workouttracker.Services.TemplateService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemplateServiceImplementation implements TemplateService {
    private TemplateRepository templateRepository;

    public boolean checkExists(String name) {
        if (findByName(name) == null) {return false;}
        else {return true;}
    }
    public TemplateServiceImplementation(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    @Override
    public Optional<Template> findByID(long ID) {
        return templateRepository.findById(ID);
    }

    @Override
    public List<Template> findAll() {
        return templateRepository.findAll();
    }

    @Override
    public Template findByName(String name) { return templateRepository.findByName(name); }

    @Override
    public Template save(Template template) { return templateRepository.save(template); }

    @Override
    public void delete(Template template) { templateRepository.delete(template); }

    public List<Template> findByUserID(User user) { return templateRepository.findByUserID(user); }
}
