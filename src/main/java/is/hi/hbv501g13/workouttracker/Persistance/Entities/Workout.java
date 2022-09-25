package is.hi.hbv501g13.workouttracker.Persistance.Entities;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class Workout {
    private long ID;
    private Date date;

    //private List<Exercise> exercises = new ArrayList<>();

    public Workout(long ID, Date date) {
        this.ID = ID;
        this.date = date;
    }

    public long getID() {
        return ID;
    }

    public Date getDate() {
        return date;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
