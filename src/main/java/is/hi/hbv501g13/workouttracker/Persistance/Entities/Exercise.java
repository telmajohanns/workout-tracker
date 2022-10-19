package is.hi.hbv501g13.workouttracker.Persistance.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String userID;
    private String name;
    @Embedded
    private Sett sets;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Exercise() {
    }

    public Exercise(String userID, String name, Sett sets, User user) {
        this.userID = userID;
        this.name = name;
        this.sets = sets;
        this.user = user;
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

    public Sett getSets() {
        return sets;
    }

    public void setSets(Sett sets) {
        this.sets = sets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
