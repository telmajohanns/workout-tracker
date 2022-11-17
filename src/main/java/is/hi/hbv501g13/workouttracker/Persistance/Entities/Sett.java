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
    @OneToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
    private int setNr;
    private int weightDist;
    private int repsTime;

    public Sett() {
    }

    public Sett(Workout workout, Exercise exercise, int setNr, int wightDist, int repsTime) {
        this.workout = workout;
        this.exercise = exercise;
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

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
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
