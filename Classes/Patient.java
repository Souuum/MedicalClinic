package MedicalClinic.Classes;

/**
 * @author Souuum
 */

import java.util.Date;

public class Patient extends Person {

    private String insuranceCompany;

    public Patient() {
    }

    public Patient(String f, String l, String s, Date d, String p, String i) {
        super(f, l, s, d, p);
        setInsuranceCompany(i);
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        // exception handling
        if (insuranceCompany == null || insuranceCompany.isEmpty()) {
            throw new IllegalArgumentException("Insurance company cannot be empty");
        }
        this.insuranceCompany = insuranceCompany;
    }

    public void makeAppointment(Patient patient, Doctor doctor, Date date, String typeAppointment) {
        // TODO
        

    }

    @Override
    public String toString() {
        return "Patient{" + "firstName=" + firstName + ", lastName=" + lastName + ", socialNumber=" + socialNumber
                + ", birthDate=" + birthDate + ", phoneNumber=" + phoneNumber + ", insuranceCompany=" + insuranceCompany
                + '}';
    }

}
