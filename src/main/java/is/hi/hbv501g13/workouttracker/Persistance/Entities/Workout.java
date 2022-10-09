package is.hi.hbv501g13.workouttracker.Persistance.Entities;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
public class Workout {
    private long ID;
    private LocalDate date;
    private ArrayList<Exercise> exercises = new ArrayList<>();

    public Workout() {
    }

    public Workout(LocalDate date, ArrayList<Exercise> exercises) {
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

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }
}
