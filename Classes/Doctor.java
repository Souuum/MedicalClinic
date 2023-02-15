package MedicalClinic.Classes;

/**
 * @author Souuum
 */

import java.util.Date;

public class Doctor extends Person {

    private String specialty;

    public Doctor() {
    }

    public Doctor(String f, String l, String s, Date d, String p, String i, String sp) {
        super(f, l, s, d, p);
        setSpecialty(sp);
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        if (specialty == null || specialty.isEmpty()) {
            throw new IllegalArgumentException("Specialty cannot be empty");
        }
        this.specialty = specialty; 
    }

    @Override
    public String toString() {
        return "Doctor{" + "firstName=" + firstName + ", lastName=" + lastName + ", socialNumber=" + socialNumber
                + ", birthDate=" + birthDate + ", phoneNumber=" + phoneNumber + ", specialty=" + specialty + '}';
    }

}
