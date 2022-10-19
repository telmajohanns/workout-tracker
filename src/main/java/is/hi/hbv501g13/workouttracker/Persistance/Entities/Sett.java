package is.hi.hbv501g13.workouttracker.Persistance.Entities;

import javax.persistence.Embeddable;

@Embeddable
public class Sett {
    private int setNr;
    private int wightDist;
    private int repsTime;

    public Sett() {
    }

    public Sett(int setNr, int wightDist, int repsTime) {
        this.setNr = setNr;
        this.wightDist = wightDist;
        this.repsTime = repsTime;
    }

    public int getSetNr() {
        return setNr;
    }

    public void setSetNr(int setNr) {
        this.setNr = setNr;
    }

    public int getWightDist() {
        return wightDist;
    }

    public void setWightDist(int wightDist) {
        this.wightDist = wightDist;
    }

    public int getRepsTime() {
        return repsTime;
    }

    public void setRepsTime(int repsTime) {
        this.repsTime = repsTime;
    }
}
