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


    @OneToMany(mappedBy = "userID", fetch = FetchType.LAZY)
    private List<Exercise> exercises = new ArrayList<>();

    public Template() {
    }

    public Template(String name, User user, List<Exercise> exercises) {
        this.name = name;
        this.userID = user;
        //this.userID = user.getID();
        this.exercises = exercises;
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
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises.addAll(exercises);
        //this.exercises = exercises;
    }

    public void setUser(User user) {this.userID = user;}
}
