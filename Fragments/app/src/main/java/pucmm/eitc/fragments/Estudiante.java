package pucmm.eitc.fragments;

import java.io.Serializable;

public class Estudiante implements Serializable {
    private String firstName;
    private String lastName;
    private String ID;

    public Estudiante() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
