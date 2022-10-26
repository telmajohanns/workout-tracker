package is.hi.hbv501g13.workouttracker.Persistance.Entities;

import javax.persistence.*;

@Entity
@Table(name = "setts")
public class Sett {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Workout workout;
    //TODO breyta í object og hafa manytoone
    private String exercise;
    private int setNr;
    private int weightDist;
    private int repsTime;

    public Sett() {
    }

    public Sett(Workout workout, String exerciseName, int setNr, int wightDist, int repsTime) {
        this.workout = workout;
        this.exercise = exerciseName;
        this.setNr = setNr;
        this.weightDist = wightDist;
        this.repsTime = repsTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public int getSetNr() {
        return setNr;
    }

    public void setSetNr(int setNr) {
        this.setNr = setNr;
    }

    public int getWeightDist() {
        return weightDist;
    }

    public void setWeightDist(int weightDist) {
        this.weightDist = weightDist;
    }

    public int getRepsTime() {
        return repsTime;
    }

    public void setRepsTime(int repsTime) {
        this.repsTime = repsTime;
    }
}
