package is.hi.hbv501g13.workouttracker.Persistance.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String userNAme;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Workout> workouts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Exercise> exercises = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Template> templates = new ArrayList<>();

    public User() {
    }

    public User(String userNAme, String password) {
        this.userNAme = userNAme;
        this.password = password;
    }
}
