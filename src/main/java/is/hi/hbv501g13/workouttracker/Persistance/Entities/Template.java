package is.hi.hbv501g13.workouttracker.Persistance.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "templates")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String name;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private User userID;
    //private Long userID;


    //@OneToMany(mappedBy = "userID", fetch = FetchType.LAZY)
    @ElementCollection
    private List<Exercise> templateExercises = new ArrayList<>();

    public Template() {
    }

    public Template(String name, User user, List<Exercise> templateExercises) {
        this.name = name;
        this.userID = user;
        //this.userID = user.getID();
        this.templateExercises = templateExercises;
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
        return templateExercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.templateExercises.addAll(exercises);
        //this.exercises = exercises;
    }
    public void addExercise(Exercise exercise) {
        this.templateExercises.add(exercise);
    }

    public void setUser(User user) {this.userID = user;}
}
