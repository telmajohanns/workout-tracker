package is.hi.hbv501g13.workouttracker.Services;

import is.hi.hbv501g13.workouttracker.Persistance.Entities.Template;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TemplateService {
    Optional<Template> findByID(long ID);
    List<Template> findAll();
    Template findByName(String name);
    Template save(Template template);
    void delete(Template template);
}
