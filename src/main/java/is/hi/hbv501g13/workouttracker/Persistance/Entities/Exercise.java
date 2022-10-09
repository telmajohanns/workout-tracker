package is.hi.hbv501g13.workouttracker.Persistance.Entities;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Exercise {
    private Long ID;
    private String userID;
    private String name;
    private ArrayList<Integer> sets = new ArrayList<Integer>();

    public Exercise() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getSets() {
        return sets;
    }

    public void setSets(ArrayList<Integer> sets) {
        this.sets = sets;
    }

    public Exercise(String userID, String name, ArrayList<Integer> sets) {
        this.userID = userID;
        this.name = name;
        this.sets = sets;
    }
}
