package Classes;

import java.util.Date;
import java.util.ArrayList;

public class Patient extends Person {

    private String insuranceCompany;
    private ArrayList<Appointment> appointments;
    private ArrayList<Billing> billings;
    PatientManager pm = new PatientManager();

    public Patient() {
    }

    public Patient(String f, String l, String s, Date date, String p, String i) {
        super(f, l, s, date, p);
        setInsuranceCompany(i);
        appointments = new ArrayList<>();
        billings = new ArrayList<>();
    }

    public Patient(String f, String l, String s, String d, String p, String i) {
        super(f, l, s, d, p);
        setInsuranceCompany(i);
        appointments = new ArrayList<>();
        billings = new ArrayList<>();
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

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public ArrayList<Billing> getBillings() {
        return billings;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public void addBilling(Billing billing) {
        billings.add(billing);
    }

    public void removeBilling(Billing billing) {
        billings.remove(billing);
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
