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
    //@OneToMany(fetch = FetchType.LAZY)
    @ElementCollection
    private List<Sett> sets = new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private User userID;

    public Workout() {
    }

    public Workout(LocalDate date, List<Sett> sets, User userID) {
        this.date = date;
        this.sets = sets;
        this.userID = userID;
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

    public List<Sett> getSets() {
        return sets;
    }

    public void setSets(List<Sett> sets) {
        this.sets = sets;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }
}
