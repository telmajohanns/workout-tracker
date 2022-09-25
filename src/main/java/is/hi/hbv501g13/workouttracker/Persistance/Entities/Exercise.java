package is.hi.hbv501g13.workouttracker.Persistance.Entities;

public class Exercise {
    private String name;
    private int sets;
    private int reps;
    private int weight;

    public Exercise(String name) {
        this.name = name;
    }

    public Exercise(int sets, int reps, int weight) {
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
