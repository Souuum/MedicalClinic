package Classes;

/**
 * @author Souuum
 */

import java.util.Date;
import java.util.ArrayList;

public class Patient extends Person {

    private String insuranceCompany;
    private ArrayList<String> medicalHistory;
    private ArrayList<Appointment> appointments;
    private ArrayList<Billing> billings;

    public Patient() {
    }

    public Patient(String f, String l, String s, Date d, String p, String i) {
        super(f, l, s, d, p);
        setInsuranceCompany(i);
        appointments = new ArrayList<>();
        billings = new ArrayList<>();
        medicalHistory = new ArrayList<>();
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

    public ArrayList<String> getMedicalHistory() {
        return medicalHistory;
    }

    public void addMedicalHistory(String history) {
        medicalHistory.add(history);
    }

    public void removeMedicalHistory(String history) {
        medicalHistory.remove(history);
    }

    public String hasAppointmentWithDoctor(Doctor doctor) {
        for (Appointment appointment : appointments) {
            if (appointment.getDoctor().equals(doctor)) {
                return "Patient has an appointment with doctor " + doctor.getFirstName() + " " + doctor.getLastName()
                        + " on " + appointment.getDate();
            }
        }
        return "Patient has no appointment with doctor " + doctor.getFirstName() + " " + doctor.getLastName();
    }

    public String listBillings() {
        if (billings.isEmpty()) {
            return "Patient has no billings";
        } else {
            System.out.println("Billings to pay:");
            for (Billing billing : billings) {
                return "Patient has a billing of " + billing.getCosts() + " for " + billing.getServices();
            }
        }
        return "";
    }

    @Override
    public String toString() {
        return "Patient :\n" + "First Name = " + firstName + "\nLast Name = " + lastName + "\nSocial Number = "
                + socialNumber
                + "\nDate birth = " + birthDate + "\nPhone Number = " + phoneNumber + "\nInsurance Company = "
                + insuranceCompany;
    }

}
