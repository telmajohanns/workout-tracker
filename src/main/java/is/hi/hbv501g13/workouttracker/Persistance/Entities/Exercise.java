package is.hi.hbv501g13.workouttracker.Persistance.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private User userID;
    //private Long userID;
    private String name;
    /**@ManyToOne(fetch =  FetchType.LAZY)
    private List<Template> templates = new ArrayList<>();
    **/

    public Exercise() {
    }

    public Exercise(User user, String name) {
        this.userID = user;
        //this.userID = this.user.getID();
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public void setUser(User user) {
        this.userID = user;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
