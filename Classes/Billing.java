package Classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Billing {
    private Doctor doctor;
    private Patient patient;
    private Appointment appointment;
    private ArrayList<String> services;
    private double costs;

    public Billing() {
    }

    public Billing(Appointment a, Double c) {
        setPatient(a.getPatient());
        setDoctor(a.getDoctor());
        setAppointment(a);
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        try {
            if (doctor == null) {
                throw new IllegalArgumentException("Doctor cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        try {
            if (patient == null) {
                throw new IllegalArgumentException("Patient cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.patient = patient;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        try {
            if (appointment == null) {
                throw new IllegalArgumentException("Appointment cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.appointment = appointment;
    }

    public ArrayList<String> getServices() {
        return services;
    }

    public ArrayList<Double> getCosts() {
        return costs;
    }

    public void addService(String service, double cost) {
        services.add(service);
        costs.add(cost);
    }

    public void removeService(String service) {
        int index = services.indexOf(service);
        services.remove(index);
        costs.remove(index);
    }

    public double getTotalCost() {
        double total = 0;
        for (double cost : costs) {
            total += cost;
        }
        return total;
    }

    public void printBill() {
        System.out.println("Patient: " + patient.getFirstName() + " " + patient.getLastName());
        System.out.println("Insurance Company: " + patient.getInsuranceCompany());
        System.out.println("Services: ");
        for (int i = 0; i < services.size(); i++) {
            System.out.println(services.get(i) + " - $" + costs.get(i));
        }
        System.out.println("Total: $" + getTotalCost());
    }

    public void printMedicalHistory() {
        System.out.println("Patient: " + patient.getFirstName() + " " + patient.getLastName());
        System.out.println("Insurance Company: " + patient.getInsuranceCompany());
        System.out.println("Medical History: ");
        for (String medicalHistory : patient.getMedicalHistory()) {
            System.out.println(medicalHistory);
        }
    }

    public void printAppointmentHistory() {
        System.out.println("Patient: " + patient.getFirstName() + " " + patient.getLastName());
        System.out.println("Insurance Company: " + patient.getInsuranceCompany());
        System.out.println("Appointment History: ");
        for (Appointment appointment : patient.getAppointments()) {
            System.out.println(appointment.getDate() + " - " + appointment.getDoctor().getFirstName() + " "
                    + appointment.getDoctor().getLastName());
        }
    }

    @Override

    public String toString() {
        return "Billing{" + "patient=" + patient + ", services=" + services + ", costs=" + costs + '}';
    }

}
