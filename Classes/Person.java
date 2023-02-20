package Classes;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @author Souuum
 */

public abstract class Person {
    protected java.text.SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    protected String firstName;
    protected String lastName;
    protected String socialNumber;
    protected String birthDate;
    protected String phoneNumber;

    public Person() {
    }

    public Person(String f, String l, String s, Date date, String p) {
        setFirstName(f);
        setLastName(l);
        setSocialNumber(s);
        setBirthDate(date);
        setPhoneNumber(p);
    }

    public Person(String f, String l, String s, String date, String p) {
        setFirstName(f);
        setLastName(l);
        setSocialNumber(s);
        setBirthDate(date);
        setPhoneNumber(p);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        // exception handling
        try {
            if (firstName == null || firstName.isEmpty()) {
                throw new IllegalArgumentException("First name cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        // exception handling
        try {
            if (lastName == null || lastName.isEmpty()) {
                throw new IllegalArgumentException("Last name cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.lastName = lastName;
    }

    public String getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(String socialNumber) {
        // exception handling
        try {
            if (socialNumber == null || socialNumber.isEmpty()) {
                throw new IllegalArgumentException("Social number cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.socialNumber = socialNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date date) {
        try {
            if (date == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Error: Null value in Appointment constructor");
            return;
        }
        this.birthDate = sdf.format(date);
    }

    public void setBirthDate(String date) {
        try {
            if (date == null || date.isEmpty()) {
                throw new IllegalArgumentException("Birth date cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.birthDate = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        // exception handling
        try {
            if (phoneNumber == null || phoneNumber.isEmpty()) {
                throw new IllegalArgumentException("Phone number cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", socialNumber=" + socialNumber
                + ", birthDate=" + birthDate + ", phoneNumber=" + phoneNumber + '}';
    }

    public String getName() {
        // This methods returns only the first and last name of the person, used in some
        // methods
        return this.firstName + " " + this.lastName;
    }

}
