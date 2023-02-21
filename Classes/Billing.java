package Classes;

import java.text.*;
import java.util.*;

public class Billing {

    private Patient patient;
    private Doctor doctor;
    private String date;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private double amount;

    public Billing() {
    }

    public Billing(Patient patient, Doctor doctor, Date date, double amount) {
        setPatient(patient);
        setDoctor(doctor);
        setDate(date);
        setAmount(amount);
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        try {
            if (patient == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Error: Null value in Billing constructor");
            return;
        }
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }

    public void setDoctor(Doctor doctor) {
        try {
            if (doctor == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Error: Null value in Billing constructor");
            return;
        }
        this.doctor = doctor;
    }

    public String getDate() {
        return this.sdf.format(this.date);
    }

    public void setDate(Date date) {
        try {
            if (date == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Error: Null value in Billing constructor");
            return;
        }
        this.date = sdf.format(date);
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        try {
            if (amount < 0) {
                throw new IllegalArgumentException("Amount cannot be negative");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.amount = amount;
    }

    public void printBill() {
        System.out.println(" Bill for " + this.patient.getName());
        System.out.println(" Doctor: " + this.doctor.getName());
        System.out.println(" Date: " + this.sdf.format(this.date));
        System.out.println(" Amount: " + this.amount);
    }

    @Override
    public String toString() {
        return "{" +
                " patient='" + getPatient() + "'" +
                ", doctor='" + getDoctor() + "'" +
                ", date='" + getDate() + "'" +
                ", amount='" + getAmount() + "'" +
                "}";
    }

}
