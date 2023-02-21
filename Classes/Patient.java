package Classes;

import java.util.Date;
import java.util.ArrayList;

public class Patient extends Person {

    private String insuranceCompany;
    PatientManager pm = new PatientManager();

    public Patient() {
    }

    public Patient(String f, String l, String s, Date date, String p, String i) {
        super(f, l, s, date, p);
        setInsuranceCompany(i);
    }

    public Patient(String f, String l, String s, String d, String p, String i) {
        super(f, l, s, d, p);
        setInsuranceCompany(i);
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        // exception handling

        try {
            if (insuranceCompany == null || insuranceCompany.isEmpty()) {
                throw new IllegalArgumentException("Insurance company cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.insuranceCompany = insuranceCompany;
    }

    public String toJSON() {
        return "{\n" +
                "  \"firstName\": \"" + firstName + "\",\n" +
                "  \"lastName\": \"" + lastName + "\",\n" +
                "  \"socialNumber\": \"" + socialNumber + "\",\n" +
                "  \"birthDate\": \"" + birthDate + "\",\n" +
                "  \"phoneNumber\": \"" + phoneNumber + "\",\n" +
                "  \"insuranceCompany\": \"" + insuranceCompany + "\"\n" +
                "}";
    }

    @Override
    public String toString() {
        return "Patient{" + "firstName :" + firstName + ", lastName :" + lastName + ", socialNumber :" + socialNumber
                + ", birthDate :" + birthDate + ", phoneNumber :" + phoneNumber + ", insuranceCompany :"
                + insuranceCompany
                + '}';
    }

}
