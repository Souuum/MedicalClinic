package MedicalClinic.Classes;

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
        setFirstName(f);
        setLastName(l);
        setSocialNumber(s);
        setBirthDate(d);
        setPhoneNumber(p);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        // exception handling
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        // exception handling
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        this.lastName = lastName;
    }

    public String getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(String socialNumber) {
        // exception handling
        if (socialNumber == null || socialNumber.isEmpty()) {
            throw new IllegalArgumentException("Social number cannot be empty");
        }
        this.socialNumber = socialNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        // exception handling
        if (birthDate == null) {
            throw new IllegalArgumentException("Birth date cannot be empty");
        }
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        // exception handling
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
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
