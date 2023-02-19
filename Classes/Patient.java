package Classes;

/**
 * @author Souuum
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Patient extends Person {

    private Scanner sc = new Scanner(System.in);
    private String insuranceCompany;
    private ArrayList<String> medicalHistory;
    private ArrayList<Appointment> appointments;
    private ArrayList<Billing> billings;
    PatientManager pm = new PatientManager();

    public void menuPatient() {
        int option = 0;
        System.out.println("Choose an option :");

        while (option != 13) {
            System.out.println("1. List all patients");
            System.out.println("2. Search and display a patient");
            System.out.println("3. Add a patient");
            System.out.println("4. Add patient by file");
            System.out.println("5. Download patient file");
            System.out.println("6. Update a patient");
            System.out.println("7. Delete a patient");
            System.out.println("8. List all appointments");
            System.out.println("9. Search and display an appointment");
            System.out.println("10. Add an appointment");
            System.out.println("11. Update an appointment");
            System.out.println("12. Delete an appointment");
            System.out.println("13. Return to main menu");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("List all patients");
                    System.out.println("====================================");
                    pm.listAllPatients();
                    break;
                case 2:
                    System.out.println("Search and display a patient");
                    System.out.println("====================================");
                    pm.searchPatient();
                    break;
                case 3:
                    System.out.println("Add a patient");
                    System.out.println("====================================");
                    pm.addPatient();
                    break;
                case 4:
                    System.out.println("Add patient by file");
                    System.out.println("====================================");
                    try {
                        pm.addPatientByFile("Classes/InfoPatient.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("Download patient file");
                    System.out.println("====================================");
                    try {
                        pm.writeFile("DownloadPatient.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("Update a patient");
                    System.out.println("====================================");
                    break;
                case 7:
                    System.out.println("Delete a patient");
                    System.out.println("====================================");
                    pm.deletePatient();
                    break;
                case 8:
                    System.out.println("List all appointments");
                    System.out.println("====================================");
                    break;
                case 9:
                    System.out.println("Search and display an appointment");
                    System.out.println("====================================");
                    break;
                case 10:
                    System.out.println("Add an appointment");
                    System.out.println("====================================");
                    break;
                case 11:
                    System.out.println("Update an appointment");
                    System.out.println("====================================");
                    break;
                case 12:
                    System.out.println("Delete an appointment");
                    System.out.println("====================================");
                    break;
                case 13:
                    System.out.println("Return to main menu");
                    System.out.println("====================================");
                    break;
                default:
                    System.out.println("Invalid option");
                    System.out.println("====================================");
            }

        }

    }

    public Patient() {
    }

    public Patient(String f, String l, String s, String d, String p, String i) {
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
        return "Patient{" + "firstName :" + firstName + ", lastName :" + lastName + ", socialNumber :" + socialNumber
                + ", birthDate :" + birthDate + ", phoneNumber :" + phoneNumber + ", insuranceCompany :"
                + insuranceCompany
                + '}';
    }

}
