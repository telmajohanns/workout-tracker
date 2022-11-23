package is.hi.hbv501g13.workouttracker.Persistance.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "templates")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String name;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private User userID;

    @ElementCollection
    @JoinTable(name="template_exercises")
    @JoinColumns({@JoinColumn(name="list_of_exercises_id"), @JoinColumn(name="id")})
    @GeneratedValue(generator = "increment")
    @CollectionId(column = @Column(name = "template_exercises_id", nullable = false),
            generator ="increment", type = @Type(type = "long"))
    private List<Exercise> listOfExercises = new ArrayList<>();


    public Template() {
    }

    public Template(String name, User user) {
        this.name = name;
        this.userID = user;

    }



    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exercise> getExercises() {
        return listOfExercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.listOfExercises.addAll(exercises);
    }
    public void addExercise(Exercise exercise) {
        this.listOfExercises.add(exercise);
    }

    public void setUser(User user) {this.userID = user;}
}
