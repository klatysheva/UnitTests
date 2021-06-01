package de.telekom.sea.interfaces;

public class Person extends BaseObject {

    private String name;
    private String surname;

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getSurname() {
        return surname;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public boolean equals(final Person pers) {
        if (pers == null) {
            return false;
        }
        else if (this == pers) {
            return true;
        }
        else if (getClass() != pers.getClass()) {  //condition is never met
            return false;
        }
        else if (this.name.equals(pers.name) && this.surname.equals(pers.surname)) {// type check
            return true;
        }
        else {
            return false;
        }
    }
}
