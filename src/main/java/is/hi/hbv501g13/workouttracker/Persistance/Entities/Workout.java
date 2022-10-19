package is.hi.hbv501g13.workouttracker.Persistance.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private LocalDate date;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Exercise> exercises = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    public Workout() {
    }

    public Workout(LocalDate date, List<Exercise> exercises) {
        this.date = date;
        this.exercises = exercises;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
