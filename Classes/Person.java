package Classes;

/**
 *  @author Souuum
 */

import java.util.Date;

public abstract class Person {

    protected String firstName;
    protected String lastName;
    protected String socialNumber;
    protected Date birthDate;
    protected String phoneNumber;

    public Person() {
    }

    public Person(String f, String l, String s, Date d, String p) {
        this.firstName = f;
        this.lastName = l;
        this.socialNumber = s;
        this.birthDate = d;
        this.phoneNumber = p;
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

    public String getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", socialNumber=" + socialNumber
                + ", birthDate=" + birthDate + ", phoneNumber=" + phoneNumber + '}';
    }

    public String nameToString() {
        // This methods returns only the first and last name of the person, used in some
        // methods
        return this.firstName + " " + this.lastName;
    }

}
