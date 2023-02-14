package MedicalClinic;

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
        this.specialty = sp;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor{" + "firstName=" + firstName + ", lastName=" + lastName + ", socialNumber=" + socialNumber
                + ", birthDate=" + birthDate + ", phoneNumber=" + phoneNumber + ", insuranceCompany=" + insuranceCompany
                + ", specialty=" + specialty + '}';
    }

}
